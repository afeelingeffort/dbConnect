package com.mj.albums;

public interface IAlbumDAO {

	int insert(AlbumDTO dto); // insert는 ResultSet이 필요 없음 !!

	AlbumDTO select(int id); // id 기반 조회 / select는 결과집합을 반환하므로 반환타입 AlbumDTO 

	int delete(int id); // id 기반 삭제
	
	int update(int id, int targetId, int targetUserId); // id 기반 수정
}
