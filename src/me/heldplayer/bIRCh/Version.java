package me.heldplayer.bIRCh;

public class Version {
	public final int major, minor, build, revision;

	public Version(int major, int minor, int build, int revision) {
		this.major = major;
		this.minor = minor;
		this.build = build;
		this.revision = revision;
	}

	public boolean isOld(Version version) {
		if (version.major > major)
			return true;
		if (version.minor > minor)
			return true;
		if (version.build > build)
			return true;
		if (version.revision > revision)
			return true;
		return false;
	}
}
