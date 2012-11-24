package me.heldplayer.bIRCh;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Updater {
	public static boolean isOutdated() throws IOException {
		if (bIRCh.version.isOld(getLatestVersionInfo())) {
			return true;
		}

		return false;
	}

	public static void update() throws IOException, IllegalStateException {
		if (!isOutdated()) {
			throw new IllegalStateException("The plugin is not outdated!");
		} else {
			OutputStream out = null;
			URLConnection conn = null;
			InputStream in = null;

			try {
				URL url = new URL(bIRCh.updateUrl + "bIRCh.jar");
				out = new BufferedOutputStream(new FileOutputStream("plugins" + File.separator + "bIRCh.jar"));
				conn = url.openConnection();
				in = conn.getInputStream();
				
				byte[] buffer = new byte[1024];

				int numRead;
				while ((numRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, numRead);
				}
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (Exception ex) {
				}
				try {
					if (out != null)
						out.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	public static Version getLatestVersionInfo() throws IOException {
		URL url = new URL(bIRCh.updateUrl + "version.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		String version = in.readLine();
		in.close();

		if (version != null) {
			String[] strings = version.split(".");

			if (strings.length >= 4) {
				int major = Integer.parseInt(strings[0]);
				int minor = Integer.parseInt(strings[1]);
				int build = Integer.parseInt(strings[2]);
				int revision = Integer.parseInt(strings[3]);

				return new Version(major, minor, build, revision);
			}
		}

		return new Version(0, 0, 0, 0);
	}

	public static String[] getUpdateReasons() throws IOException {
		URL url = new URL(bIRCh.updateUrl + "reason.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		int id = 0;
		HashMap<Integer, String> reasons = new HashMap<Integer, String>();

		String message;
		while ((message = in.readLine()) != null) {
			reasons.put(id, message);
			id++;
		}

		String[] reasonStrings = new String[id];

		for (int i = 0; i < id; i++) {
			reasonStrings[i] = reasons.get(i);
		}

		return reasonStrings;
	}
}
