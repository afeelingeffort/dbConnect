package com.mj.albums;

public class AlbumService {
	private AlbumDAO albumDAO;

	public AlbumService() {
		albumDAO = new AlbumDAO();
	}

	public int insertSql(AlbumDTO dto) {
		int rowCount = 0;
		rowCount = albumDAO.insert(dto);
		return rowCount;
	}
	
	public AlbumDTO selectSql(int id) {
		AlbumDTO albumDTO = albumDAO.select(id);
		return albumDTO;
	}
	
	public int deleteSql(int id) {
		int rowCount = 0;
		rowCount = albumDAO.delete(id);
		return rowCount;
	}
	
	public int updateSql(int id, int targetId, int targetUserId) {
		int rowCount = 0;
		rowCount = albumDAO.update(id, targetId, targetUserId);
		return rowCount;
	}
}
