package com.gga.dao;

import java.util.ArrayList;

import com.gga.vo.MovieVo;

public class MovieDao extends DBConn {
	/**
	 *  ������ movie_delete_proc -> ��ȭ����
	 */
	public int delete(String movieid) {
		int result = 0;
		String sql ="delete from gga_movie where movieid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, movieid);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	/**
	 * ������ movie_update -> ��ȭ ���� update�κ�
	 */
	public int update(MovieVo movieVo) {
		int result = 0;
		String sql = "update gga_movie set movietitle=?, genre=?, moviedday=?, runtime=?, movieinfo=?,"
				+ " director=?, actor=?, mainposter=?, stillcut1=?, stillcut2=?, stillcut3=?, stillcut4=?,"
				+ " youtube=? where movieid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, movieVo.getMovietitle());
			pstmt.setString(2, movieVo.getGenre());
			pstmt.setString(3, movieVo.getMoviedday());
			pstmt.setString(4, movieVo.getRuntime());
			pstmt.setString(5, movieVo.getMovieinfo());
			pstmt.setString(6, movieVo.getDirector());
			pstmt.setString(7, movieVo.getActor());
			pstmt.setString(8, movieVo.getMainposter());
			pstmt.setString(9, movieVo.getStillcut1());
			pstmt.setString(10, movieVo.getStillcut2());
			pstmt.setString(11, movieVo.getStillcut3());
			pstmt.setString(12, movieVo.getStillcut4());
			pstmt.setString(13, movieVo.getYoutube());
			pstmt.setString(14, movieVo.getMovieid());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ������movie_register -> ��ȭ ��� insert�κ�
	 */
	public int insert(MovieVo movieVo) {
		int result = 0;
		
		String sql = "insert into gga_movie( movieid, movietitle, genre, moviedday, runtime, audience, movieinfo, director, actor, "
				+ " mainposter, stillcut1, stillcut2, stillcut3,stillcut4, youtube) values('MOVIE_'||to_char(sequ_gga_movieid.nextval, 'fm0000'),"
				+ " ?,?,?,?,0,?,?,?,?,?,?,?,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, movieVo.getMovietitle());
			pstmt.setString(2, movieVo.getGenre());
			pstmt.setString(3, movieVo.getMoviedday());
			pstmt.setString(4, movieVo.getRuntime());
			pstmt.setString(5, movieVo.getMovieinfo());
			pstmt.setString(6, movieVo.getDirector());
			pstmt.setString(7, movieVo.getActor());
			pstmt.setString(8, movieVo.getMainposter());
			pstmt.setString(9, movieVo.getStillcut1());
			pstmt.setString(10, movieVo.getStillcut2());
			pstmt.setString(11, movieVo.getStillcut3());
			pstmt.setString(12, movieVo.getStillcut4());
			pstmt.setString(13, movieVo.getYoutube());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ��üī��Ʈ ��������
	 */
	public int totalRowCount() {
			int count = 0;
			String sql = "select count(*) from gga_movie";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {				
					count = rs.getInt(1);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return count;		
		}
	
	/* ��ü ����Ʈ */
	public ArrayList<MovieVo> getResultList(int startCount, int endCount){
		
		ArrayList<MovieVo> list = new ArrayList<MovieVo>();
		try{
			String sql = " select rno, movieid, movietitle, genre, moviedday, runtime, audience" + 
					" from(select rownum rno, movieid, movietitle, genre, moviedday, runtime, audience" + 
					"          from(select movieid, movietitle, genre, moviedday, runtime, audience from gga_movie order by movieid))" + 
					" where rno between ? and ?";
			
			getPreparedStatement(sql);
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MovieVo movieVo = new MovieVo();
				movieVo.setRno(rs.getInt(1));
				movieVo.setMovieid(rs.getString(2));
				movieVo.setMovietitle(rs.getString(3));
				movieVo.setGenre(rs.getString(4));
				movieVo.setMoviedday(rs.getString(5));
				movieVo.setRuntime(rs.getString(6));
				movieVo.setAudience(rs.getString(7));
				
				list.add(movieVo);
			}
			
		}catch(Exception e){ e.printStackTrace();}
		return list;
	}
	
	/**
	 * admin -> movie_list ��ȭ��ü����Ʈ 
	 */
	public ArrayList<MovieVo> select(){
		ArrayList<MovieVo> list = new ArrayList<MovieVo>();
		
		String sql="select rownum rno, movieid, movietitle, genre, moviedday, runtime, audience "
				+ " from(select movieid, movietitle, genre, moviedday, runtime, audience from gga_movie order by movieid)";
		getPreparedStatement(sql);
			
		try {
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVo movieVo = new MovieVo();
				movieVo.setRno(rs.getInt(1));
				movieVo.setMovieid(rs.getString(2));
				movieVo.setMovietitle(rs.getString(3));
				movieVo.setGenre(rs.getString(4));
				movieVo.setMoviedday(rs.getString(5));
				movieVo.setRuntime(rs.getString(6));
				movieVo.setAudience(rs.getString(7));
				
				list.add(movieVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/**
	 * header.jsp�� �˻���� seaselect()
	 */
	public MovieVo seaselect(String movietitle) {
		MovieVo movieVo = new MovieVo();
		
		String sql ="select movieid, movietitle, genre, moviedday, runtime, audience, "
				+ " movieinfo, actor, director, mainposter, stillcut1, stillcut2, stillcut3,"
				+ " stillcut4, youtube from gga_movie where movietitle like ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, "%" + movietitle + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movieVo.setMovieid(rs.getString(1));
				movieVo.setMovietitle(rs.getString(2));
				movieVo.setGenre(rs.getString(3));
				movieVo.setMoviedday(rs.getString(4));
				movieVo.setRuntime(rs.getString(5));
				movieVo.setAudience(rs.getString(6));
				movieVo.setMovieinfo(rs.getString(7));
				movieVo.setDirector(rs.getString(8));
				movieVo.setActor(rs.getString(9));
				movieVo.setMainposter(rs.getString(10));
				movieVo.setStillcut1(rs.getString(11));
				movieVo.setStillcut2(rs.getString(12));
				movieVo.setStillcut3(rs.getString(13));
				movieVo.setStillcut4(rs.getString(14));
				movieVo.setYoutube(rs.getString(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movieVo;
	}
	
/**
 * index.jsp���� ��ȭ������ Ŭ���� movieinfo�� �Ѿ�� mselect()
 */
	public MovieVo mselect(String movieid) {
		MovieVo movieVo = new MovieVo();
		String sql = "select movieid, movietitle, genre, moviedday, runtime, audience, movieinfo, "
				+ " director, actor, mainposter, stillcut1, stillcut2, stillcut3, stillcut4, youtube "
				+ " from gga_movie where movieid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, movieid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				movieVo.setMovieid(rs.getString(1));
				movieVo.setMovietitle(rs.getString(2));
				movieVo.setGenre(rs.getString(3));
				movieVo.setMoviedday(rs.getString(4));
				movieVo.setRuntime(rs.getString(5));
				movieVo.setAudience(rs.getString(6));
				movieVo.setMovieinfo(rs.getString(7));
				movieVo.setDirector(rs.getString(8));
				movieVo.setActor(rs.getString(9));
				movieVo.setMainposter(rs.getString(10));
				movieVo.setStillcut1(rs.getString(11));
				movieVo.setStillcut2(rs.getString(12));
				movieVo.setStillcut3(rs.getString(13));
				movieVo.setStillcut4(rs.getString(14));
				movieVo.setYoutube(rs.getString(15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movieVo;
	}
}
