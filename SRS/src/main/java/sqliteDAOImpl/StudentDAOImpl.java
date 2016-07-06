package sqliteDAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import SRSDAO.StudentDAO;
import model.Person;

import model.Student;
import util.DBUtil;





public class StudentDAOImpl implements StudentDAO{
	private Connection conn = DBUtil.getSqliteConnection();
	private PreparedStatement stmt=null;
	private SQLException ex=null;
	
	@Override
	public Student getStudent(String ssn) {
		// TODO Auto-generated method stub
		
		Student stu=null;
		
		try{
			
			stmt=conn.prepareStatement("SELECT ssn,name,major,degree FROM Student WHERE ssn=?");
			stmt.setString(1, ssn);
			/*stmt.setString(1, admin.getCname());
			stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				stu=new Student(rs.getString("name"),rs.getString("ssn"),rs.getString("major"),rs.getString("degree"));
				
				
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
		return stu;
	}

	@Override
	public Person signInStudent(Person admin) {
		// TODO Auto-generated method stub
		Student stu=null;
		
		try{
			
			stmt=conn.prepareStatement("SELECT ssn,name,major,degree FROM Student WHERE ssn=? and password=?");
			stmt.setString(1, admin.getSsn());
			stmt.setString(2, admin.getPassword());
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				stu=new Student(rs.getString("name"),rs.getString("ssn"),rs.getString("major"),rs.getString("degree"));
				
				
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
		return stu;
	}
	
	
	
	
	
}
