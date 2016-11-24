package mojong;

import org.testng.annotations.Test;

public class TestRoom {

	@Test
	public void TestRoom() {
		Room room = new Room();
		room.setJushu(4);
		room.setChangshu(2);
		assert room.getJuShuString().equals("南一局");
		assert room.getChangShuString().equals("3本场");

	}

}
