package sqliteDAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import SRSDAO.TranscriptDAO;

import model.ScheduleOfClasses;
import model.Section;
import model.Transcript;
import model.TranscriptEntry;
import util.DBUtil;



public class TranscriptDAOImpl implements TranscriptDAO{
	private Connection conn = DBUtil.getSqliteConnection();
	private PreparedStatement stmt=null;
	private SQLException ex=null;
	
	@Override
	public String  getStudentSsnfromTranscript(Section st) {
		// TODO Auto-generated method stub
		String ssnTranscript=null;
		
		try{
			
			stmt=conn.prepareStatement("SELECT studentNo FROM Transcript where sectionNo=?");
			stmt.setInt(1, st.getSectionNo());
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				//tra.getStudent().setName(n);; TranscriptEntry(rs.getString("ssn"),rs.getString("name"),"", rs.getString("department"));
				
				ssnTranscript=rs.getString("studentNo");
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return ssnTranscript;
	}

	@Override
	public Transcript getTranscript(String ssn) {
		// TODO Auto-generated method stub
		Transcript transcript=new Transcript();
		TranscriptEntry transcriptEntry=new TranscriptEntry();
		
		try{
			
			stmt=conn.prepareStatement("SELECT grade,courseName FROM Transcript where studentNo=?");
			stmt.setString(1, ssn);
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				//tra.getStudent().setName(n);; TranscriptEntry(rs.getString("ssn"),rs.getString("name"),"", rs.getString("department"));
				transcriptEntry.setCourseName(rs.getString("courseName"));
				transcriptEntry.setGrade(rs.getString("grade"));
				transcript.addTranscriptEntry(transcriptEntry);
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return transcript;
	}

	@Override
	public void deleteTranscript(String[] drops,String ssn) {
		// TODO Auto-generated method stub
		try{
			
			for(int i=0;i<drops.length;i++){
				stmt=conn.prepareStatement("DELETE FROM Transcript WHERE sectionNo=? and studentNo=?");
				stmt.setString(1,drops[i]);
				stmt.setString(2, ssn);
				stmt.executeUpdate();
			}
		}catch(SQLException e){
			ex=e;
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					if(ex==null){
						ex=e;
					}
				}
			}
		if(ex!=null){
			throw new RuntimeException(ex);
		}
		}
	}

	@Override
	public List<String> getTranscript(String ssn, ScheduleOfClasses scs) {
		// TODO Auto-generated method stub
		List<String> pros=null;
		
		
		try{
			for(String key : scs.getSectionsOffered().keySet()){
			stmt=conn.prepareStatement("SELECT courseName FROM Transcript where sectionNo=? and studentNo=?");
			stmt.setInt(1, scs.getSectionsOffered().get(key).getSectionNo());
			stmt.setString(2, ssn);
			ResultSet rs=stmt.executeQuery();
			
			pros=new ArrayList<String>();
			while(rs.next()){
				//pro=new Professor(rs.getString("ssn"),rs.getString("name"),"", rs.getString("department"));
				
				pros.add(String.valueOf(rs.getInt("sectionNo")));
			}}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return pros;
	}
	
	
	
	
	
}
