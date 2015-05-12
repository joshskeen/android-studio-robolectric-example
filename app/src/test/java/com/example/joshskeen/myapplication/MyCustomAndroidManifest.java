package com.example.joshskeen.myapplication;

import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.FsFile;
import org.robolectric.util.Logger;

public class MyCustomAndroidManifest extends AndroidManifest {
    public MyCustomAndroidManifest(FsFile androidManifestFile, FsFile resDirectory, FsFile assetsDirectory) {
        super(androidManifestFile, resDirectory, assetsDirectory);
    }

    public MyCustomAndroidManifest(FsFile androidManifestFile, FsFile resDirectory, FsFile assetsDirectory, String packageName) {
        super(androidManifestFile, resDirectory, assetsDirectory, packageName);
    }

    @Override
    public Class getRClass() {
        Logger.debug("using my custon getRClass() method");
        try {
            String rClassName = getRClassName();
            return Class.forName(rClassName);
        } catch (Exception e) {
            Logger.error("Were you hoping to have an R file with this lib: " + getPackageName());
            return null;
        }
    }
}
