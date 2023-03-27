package com.mj.albums;

public class AlbumController {
	private AlbumService albumService;
	
	public AlbumController() {
		albumService = new AlbumService();
	}
	
	public int requestInsertAlbum(AlbumDTO dto) {
		int responseRow = albumService.insertSql(dto);
		return responseRow;
	}
	
	public AlbumDTO requestSelectAlbum(int id) {
		AlbumDTO dto = albumService.selectSql(id);
		return dto;
	}
	
	public int requestDeleteAlbum(int id) {
		int rowCount = 0;
		rowCount = albumService.deleteSql(id);
		return rowCount;
	}
	
	public int requestUpdate(int id, int targetId, int targetUserId) {
		int rowCount = 0;
		rowCount = albumService.updateSql(id, targetId, targetUserId);
		return rowCount;
	}
}
