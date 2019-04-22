package kooda.fp;

import java.io.FileInputStream;
import java.io.IOException;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Audio{
	public static void player() {
		AudioPlayer ap = AudioPlayer.player;
		AudioStream as;
		AudioData ad;
		ContinuousAudioDataStream loop = null;
		
		try {
		as = new AudioStream(new FileInputStream("/assets/BackgroundMusic.mp3"));
		ad = as.getData();
		loop = new ContinuousAudioDataStream(ad);
		} catch(IOException e) {
			System.out.println(e);
		}
		ap.start(loop);
	}
}

//Credit: https://www.youtube.com/watch?v=-o-gmH4A2u4
