package edu.vanderbilt.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	VideoService videoService;
	
	@Test
	public void contextLoads() {	
	}
	
	@Test
	public void videoServiceLoaded() {
		assertNotNull(videoService);
	}
	
	@Test
	public void addVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	@Test
	public void updateVideoReturnsAListOfVideos() {
	Video video = new Video();
	video.setName("test1");
	Iterable<Video> videos = videoService.addVideo(video);
	Long id = videos.iterator().next().getId();
	Video video2 = new Video();
	video2.setId(id);
	video2.setName("test2");
	Iterable<Video> videos2 = videoService.updateVideo(video2);
	System.out.print(videos2);
	boolean found = false;
	for (Video vid: videos2){
		if(vid.getId() == id){
			assertTrue(vid.getName() == video2.getName());
			found = true;
		}
	}
	// Make sure that the updated video made it in there
	assertTrue(found);

	}
	
	@Test
	public void getVideosReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos= videoService.addVideo(video);
		assertNotNull(videos);
	}

	@Test 
	public void deleteVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		Long firstId = videos.iterator().next().getId();
		Iterable<Video> videos2 = videoService.rmVideo(firstId);
		assertTrue(!videos.equals(videos2));
	}
}
