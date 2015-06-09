package com.example.joshskeen.myapplication;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.FileFsFile;
import org.robolectric.util.Logger;
import org.robolectric.util.ReflectionHelpers;

import java.util.Properties;

/**
 * Test runner customized for running unit tests either through the Gradle CLI or
 * Android Studio. The runner uses the build type and build flavor to compute the
 * resource, asset, and AndroidManifest paths.
 *
 * This test runner requires that you set the 'constants' field on the @Config
 * annotation (or the org.robolectric.Config.properties file) for your tests.
 */
public class MyCustomGradleTestRunner extends RobolectricTestRunner {
    private static final String BUILD_OUTPUT = "build/intermediates";

    public MyCustomGradleTestRunner(Class<?> klass) throws InitializationError {
        super(klass);

        Properties props = System.getProperties();
        props.setProperty("robolectric.logging.enabled", "true");
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        if (config.constants() == Void.class) {
            Logger.error("Field 'constants' not specified in @Config annotation");
            Logger.error("This is required when using RobolectricGradleTestRunner!");
            throw new RuntimeException("No 'constants' field in @Config annotation!");
        }

        final String type = getType(config);
        final String flavor = getFlavor(config);
        final String applicationId = getApplicationId(config);

        final FileFsFile res = FileFsFile.from(BUILD_OUTPUT, "res", flavor, type);
        final FileFsFile assets = FileFsFile.from(BUILD_OUTPUT, "assets", flavor, type);

        final FileFsFile manifest;
        if (FileFsFile.from(BUILD_OUTPUT, "manifests").exists()) {
            manifest = FileFsFile.from(BUILD_OUTPUT, "manifests", "full", flavor, type, "AndroidManifest.xml");
        } else {
            // Fallback to the location for library manifests
            manifest = FileFsFile.from(BUILD_OUTPUT, "bundles", flavor, type, "AndroidManifest.xml");
        }

        Logger.debug("Robolectric assets directory: " + assets.getPath());
        Logger.debug("Robolectric res directory: " + res.getPath());
        Logger.debug("Robolectric manifest path: " + manifest.getPath());
        Logger.debug("Robolectric application name: " + applicationId);
        return new MyCustomAndroidManifest(manifest, res, assets, applicationId);
//        return new AndroidManifest(manifest, res, assets, "com.example.joshskeen.myapplication");
    }

    private String getType(Config config) {
        try {
            return ReflectionHelpers.getStaticField(config.constants(), "BUILD_TYPE");
        } catch (Throwable e) {
            return null;
        }
    }

    private String getFlavor(Config config) {
        try {
            return ReflectionHelpers.getStaticField(config.constants(), "FLAVOR");
        } catch (Throwable e) {
            return null;
        }
    }

    private String getApplicationId(Config config) {
        try {
            return ReflectionHelpers.getStaticField(config.constants(), "APPLICATION_ID");
        } catch (Throwable e) {
            return null;
        }
    }
}

