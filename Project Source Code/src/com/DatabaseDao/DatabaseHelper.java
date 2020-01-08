package com.DatabaseDao;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.tomcat.util.codec.binary.Base64;

import com.Model.AadharInfo;
import com.Model.AadharPrime;
import com.Model.Address;
import com.Model.CreateAccount;
import com.Model.DisplayAllData;
import com.Model.DisplayProfile;
import com.Model.LoginAccount;
import com.Model.LoginInfo;
import com.Model.Transaction;
import com.Model.Account;
import com.Model.UserId;
import com.Model.UserInfo;
import com.Model.VariantUser;
import java.util.Date;

public class DatabaseHelper 
{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public DatabaseHelper()
	{
		
	}
	public Connection getConnection()
	{
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	public int createAccount(List<CreateAccount> list)
	{
		con=getConnection();
		int cnt=0;
		CreateAccount Accountobj=list.get(0);
		
		try 
		{
			ps=con.prepareStatement("insert into UserTempTable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,Accountobj.getFirstName());
			ps.setString(2,Accountobj.getLastName());
			ps.setString(3, Accountobj.getGender());
			ps.setString(4,Accountobj.getDateOfBirth());
			ps.setString(5,Accountobj.getArea());
			ps.setString(6,Accountobj.getCity());
			ps.setString(7,Accountobj.getState());
			ps.setLong(8,Accountobj.getPinCode());
			ps.setString(9,Accountobj.getNationality());
			ps.setLong(10,Accountobj.getAdharNo());
			ps.setLong(11,Accountobj.getMobileNo());
			ps.setString(12,Accountobj.getEmailId());
			ps.setString(13,Accountobj.getUserId());
			ps.setString(14,Accountobj.getAccType());
			ps.setString(15,Accountobj.getBranchName());
			cnt=ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return cnt;	
	}
	public List<CreateAccount> getAllData()
	{
		List<CreateAccount> lst=new ArrayList<CreateAccount>();
		con=getConnection();
		try
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from UserTempTable");
			while(rs.next())
			{
				CreateAccount a=new CreateAccount();
				a.setFirstName(rs.getString(1));
				a.setLastName(rs.getString(2));
				a.setGender(rs.getString(3));
				a.setDateOfBirth(rs.getString(4));
				a.setArea(rs.getString(5));
				a.setCity(rs.getString(6));
				a.setState(rs.getString(7));
				a.setPinCode(rs.getLong(8));
				a.setNationality(rs.getString(9));
				a.setAdharNo(rs.getLong(10));
				a.setMobileNo(rs.getLong(11));
				a.setEmailId(rs.getString(12));
				a.setUserId(rs.getString(13));
				a.setAccType(rs.getString(14));
				a.setBranchName(rs.getString(15));
				lst.add(a);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public List<DisplayAllData> getAllValidAcc()
	{
		List<DisplayAllData> lst=new ArrayList<DisplayAllData>();
		con=getConnection();
		try
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select a.Customer_id,a.Account_Type,a.Acc_Bal,a.Branch_name,"
					+ "u.User_id,r.Area,r.City,r.State,r.Pincode,p.Adhar_no,i.First_name,i.Last_name,"
					+ "i.DOB,i.Gender,i.Nationality,v.Email_Id,v.Mob_no, l.Acc_no from Account a,"
					+ "User_Id u, AddressTable r, AdharNoTable d, AdharPrime p, UserInfo i,VarientUserInfo v,"
					+ " LoginInfo1 l where a.Customer_id=u.Customer_id and a.Customer_id=r.Customer_id and "
					+ "d.Customer_id=a.Customer_id and p.Adhar_no=d.Adhar_no and p.Adhar_no=i.Adhar_no and "
					+ "p.Adhar_no=v.Adhar_no and a.Customer_id=l.Customer_id");
			while(rs.next())
			{
				DisplayAllData obj=new DisplayAllData();
				obj.setCustomerId(rs.getLong(1));
				obj.setAccountType(rs.getString(2));
				obj.setAccBal(rs.getLong(3));
				obj.setBranchName(rs.getString(4));
				obj.setUserId(rs.getString(5));
				obj.setArea(rs.getString(6));
				obj.setCity(rs.getString(7));
				obj.setState(rs.getString(8));
				obj.setPinCode(rs.getLong(9));
				obj.setAdharNo(rs.getLong(10));
				obj.setFirstName(rs.getString(11));
				obj.setLastName(rs.getString(12));
				obj.setDob(rs.getString(13));
				obj.setGender(rs.getString(14));
				obj.setNationality(rs.getString(15));
				obj.setEmail(rs.getString(16));
				obj.setMobNo(rs.getLong(17));
				obj.setAccno(rs.getLong(18));
				lst.add(obj);
			}		
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public List<Transaction> getAllTransaction()
	{
		List<Transaction> lst=new ArrayList<Transaction>();
		con=getConnection();
		try
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from TransactionAmountTable");
			while(rs.next())
			{
				Transaction a=new Transaction();
				a.setTransactionId(rs.getLong(1));
				a.setCustomerId(rs.getLong(2));
				a.setAmount(rs.getLong(3));
				a.setDateOftransaction(rs.getString(4));
				a.setStatus(rs.getString(5));
				a.setDiscription(rs.getString(6));
				lst.add(a);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}

	public List<DisplayProfile> getMyProfileAcc(String username)
	{
		List<DisplayProfile> lst=new ArrayList<DisplayProfile>();
		con=getConnection();
		try
		{
			ps=con.prepareStatement("select a.Account_Type,a.Acc_Bal,b.Branch_name,u.User_id,i.First_name,i.Last_name,v.Email_Id,"
					+ "v.Mob_no, l.Acc_no,b.IFSC_Code from Account a,User_Id u, AddressTable r,"
					+ " AdharNoTable d, AdharPrime p, UserInfo i,VarientUserInfo v, LoginInfo1 l ,"
					+ "BranchInfo b where u.User_id=? and  u.Customer_id=a.Customer_id "
					+ "and a.Customer_id=u.Customer_id and a.Customer_id=r.Customer_id and "
					+ "d.Customer_id=a.Customer_id and p.Adhar_no=d.Adhar_no and p.Adhar_no=i.Adhar_no "
					+ "and p.Adhar_no=v.Adhar_no and a.Customer_id=l.Customer_id and b.Branch_name=a.Branch_name");
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next())
			{
				DisplayProfile obj=new DisplayProfile();
				obj.setAccType(rs.getString(1));
				obj.setAccBal(rs.getLong(2));
				obj.setBranchName(rs.getString(3));
				obj.setUserId(rs.getString(4));
				obj.setFname(rs.getString(5));
				obj.setLname(rs.getString(6));
				obj.setEmail(rs.getString(7));
				obj.setMobile(rs.getLong(8));
				obj.setAccNo(rs.getLong(9));
				obj.setIfscCode(rs.getString(10));	
				lst.add(obj);
			}		
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public void splitAndCopyAccount(List<CreateAccount> lst)
	{
		CreateAccount obj=lst.get(0);
		try
		{
				Account permobj=new Account();
				Address addobj=new Address();
				AadharInfo aadhobj=new AadharInfo();
				UserInfo userobj=new UserInfo();
				VariantUser variobj=new VariantUser();
				LoginInfo logobj=new LoginInfo();
				UserId Userid = new UserId();
				AadharPrime aadharprimobj=new AadharPrime();
				
				long custid=generateCustomerId();
				permobj.setCustomerId(custid);
				permobj.setAccType(obj.getAccType());
				permobj.setAccountBal(50000);
				permobj.setBranchName(obj.getBranchName());
				List<Account> AccountList=new ArrayList<Account>();
				AccountList.add(permobj);
				int cnt1=insertPermAccount(AccountList);
				if(cnt1>0)
				{
					System.out.println("Data stored in Account Table");
				}
				else
				{
					System.out.println("Data not stored in Account Table");
				}
				
				addobj.setCustomerId(custid);
				addobj.setArea(obj.getArea());
				addobj.setCity(obj.getCity());
				addobj.setState(obj.getState());
				addobj.setPinCode(obj.getPinCode());
				List<Address> Addresslist=new ArrayList<Address>();
				Addresslist.add(addobj);
				int cnt2=insertAddress(Addresslist);
				if(cnt2>0)
				{
					System.out.println("Data stored in Address Table");
				}
				else
				{
					System.out.println("Data not stored in Address Table");
				}
				
				aadharprimobj.setAadharNo(obj.getAdharNo());
				List<AadharPrime> Aadharprimelist=new ArrayList<AadharPrime>();
				Aadharprimelist.add(aadharprimobj);
				int cnt8=insertAadharPrime(Aadharprimelist);
				if(cnt8>0)
				{
					System.out.println("Data stored in AadharPrime Table");
				}
				else
				{
					System.out.println("Data not stored in AadharPrime Table");
				}
				
				aadhobj.setCustomerId(custid);
				aadhobj.setAadharNo(obj.getAdharNo());
				List<AadharInfo> Aadharlist=new ArrayList<AadharInfo>();
			    Aadharlist.add(aadhobj);
				int cnt3=insertAadhar(Aadharlist);
				if(cnt3>0)
				{
					System.out.println("Data stored in AadharNo Table");
				}
				else
				{
					System.out.println("Data not stored in AadharNo Table");
				}
				
				userobj.setAadharNo(obj.getAdharNo());
				userobj.setFirstName(obj.getFirstName());
				userobj.setLastName(obj.getLastName());
				userobj.setDateOfBirth(obj.getDateOfBirth());
				userobj.setGender(obj.getGender());
				userobj.setNationality(obj.getNationality());
				List<UserInfo> Userlist=new ArrayList<UserInfo>();
				Userlist.add(userobj);
				int cnt4=insertUserInfo(Userlist);
				if(cnt4>0)
				{
					System.out.println("Data stored in userInfo Table");
				}
				else
				{
					System.out.println("Data not stored in userInfo Table");
				}
				
				variobj.setAadharNo(obj.getAdharNo());
				variobj.setEmailId(obj.getEmailId());
				variobj.setMobileNo(obj.getMobileNo());
				List<VariantUser> VarientUserlist=new ArrayList<VariantUser>();
				VarientUserlist.add(variobj);
				int cnt5=insertvarientuser(VarientUserlist);
				if(cnt5>0)
				{
					System.out.println("Data stored in varientuserInfo Table");
				}
				else
				{
					System.out.println("Data not stored in varientuserinfo Table");
				}
				
				logobj.setCustomerId(custid);
				int pass=generatePassword();
				String password=Integer.toString(pass);
				byte[] encode=Base64.encodeBase64(password.getBytes());
				String pass1=new String(encode);
				logobj.setPassword(pass1);
				long accno=generateAccno();
				logobj.setAccountNo(accno);
				logobj.setEmailId(obj.getEmailId());
				DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
				Date dateobj=new Date();
				logobj.setAccountCreateDate(dateformat.format(dateobj));
				List<LoginInfo> loginuser=new ArrayList<LoginInfo>();
				loginuser.add(logobj);
				int cnt6=insertLoginInfo(loginuser);
				if(cnt6>0)
				{
					System.out.println("Data stored in LoginTable Table");
				}
				else
				{
					System.out.println("Data not stored in LoginTable Table");
				}
				
				Userid.setUserId(obj.getUserId());
				Userid.setCustomerId(custid);
				List<UserId> UsidList=new ArrayList<UserId>();
				UsidList.add(Userid);
				int cnt7=insertintoUserId(UsidList);
				if(cnt7>0)
				{
					System.out.println("Data stored in UserId Table");
				}
				else
				{
					System.out.println("Data not stored in UserId Table");
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public long generateCustomerId()
	{
		con=getConnection();
		long custid=330000;
		int count=0;
		try 
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from Account");
			while(rs.next())
			{
				count++;
			}
			custid=custid+count;
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return custid;
	}
	
	public int generatePassword()
	{
		int max=99999;
		int min=1000;
		Random obj=new Random();
		int randomNum = obj.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	public long generateAccno()
	{
		long acc = 0;
		con=getConnection();
		String i="1";
		BigInteger a=new BigInteger(i);
		String accno="123000000000";
		BigInteger accountno=new BigInteger(accno);
		String cnt="0";
		BigInteger count=new BigInteger(cnt);
		try 
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from LoginInfo1");
			while(rs.next())
			{
				count=count.add(a);
			}
			accountno=accountno.add(count);
			acc=accountno.longValue();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return acc;
	}
	
	public long generateTransactionId()
	{
		long transactionid= 100;
		con=getConnection();
		long count=0;
		try 
		{
			Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from TransactionAmountTable");
			while(rs.next())
			{
				count++;
			}
			transactionid=transactionid+count;
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return transactionid;
	}
	
	public int insertAddress(List<Address> lst)
	{
		con=getConnection();
		int cnt=0;
		Address obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into AddressTable values(?,?,?,?,?)");
			ps.setLong(1, obj.getCustomerId());
			ps.setString(2, obj.getArea());
			ps.setString(3, obj.getCity());
			ps.setString(4, obj.getState());
			ps.setLong(5, obj.getPinCode());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertvarientuser(List<VariantUser> lst)
	{
		con=getConnection();
		int cnt=0;
		VariantUser obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into VarientUserInfo values(?,?,?)");
			ps.setLong(1, obj.getAadharNo());
			ps.setString(2, obj.getEmailId());
			ps.setLong(3, obj.getMobileNo());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertAadhar(List<AadharInfo> lst)
	{
		con=getConnection();
		int cnt=0;
		AadharInfo obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into AdharNoTable values(?,?)");
			ps.setLong(1, obj.getCustomerId());
			ps.setLong(2, obj.getAadharNo());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertUserInfo(List<UserInfo> lst)
	{
		con=getConnection();
		int cnt=0;
		UserInfo obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into UserInfo values(?,?,?,?,?,?)");
			ps.setLong(1, obj.getAadharNo());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getLastName());
			ps.setString(4, obj.getDateOfBirth());
			ps.setString(5, obj.getGender());
			ps.setString(6, obj.getNationality());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertPermAccount(List<Account> lst)
	{
		con=getConnection();
		int cnt=0;
		Account obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into Account values(?,?,?,?)");
			ps.setLong(1,obj.getCustomerId());
			ps.setString(2,obj.getAccType());
			ps.setLong(3,50000);
			ps.setString(4,obj.getBranchName());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertLoginInfo(List<LoginInfo> lst)
	{
		con=getConnection();
		int cnt=0;
		LoginInfo obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into LoginInfo1 values(?,?,?,?,?)");
			ps.setLong(1, obj.getCustomerId());
			ps.setString(2, obj.getPassword());
			ps.setLong(3,obj.getAccountNo());
			ps.setString(4, obj.getEmailId());
			ps.setString(5, obj.getAccountCreateDate());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertAadharPrime(List<AadharPrime> lst)
	{
		con=getConnection();
		int cnt=0;
		AadharPrime obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into AdharPrime values(?)");
			ps.setLong(1, obj.getAadharNo());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int insertintoUserId(List<UserId> lst)
	{
		con=getConnection();
		int cnt=0;
		UserId obj=lst.get(0);
		try 
		{
			ps=con.prepareStatement("insert into User_Id values(?,?)");
			ps.setString(1, obj.getUserId());
			ps.setLong(2, obj.getCustomerId());
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public int validateAccount(List<LoginAccount> list)
	{
		int cnt=0;
		LoginAccount Accountobj=list.get(0);

			try 
			{
				Long CustId = validateUserId(Accountobj.getUname());
				con=getConnection();
				ps=con.prepareStatement("select * from LoginInfo1 where Customer_id=?");
				ps.setLong(1, CustId);
				rs=ps.executeQuery();
				if(rs.next())
				{
					String pass=rs.getString(2);
					byte[] bytes=pass.getBytes();
					byte[] decode=Base64.decodeBase64(bytes);
					String pass1=new String(decode);
					
					if((Accountobj.getPass()).equals(pass1))
					{
						cnt=1;
					}
				}
				con.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return cnt;
	}
	public int insertTrasactionPin(String username, String pin)
	{
		int cnt=0;
			try 
			{
				long CustId = validateUserId(username);
				con=getConnection();
				ps=con.prepareStatement("insert into Transaction_PIN values(?,?)");
				ps.setLong(1, CustId);
				byte[] encode=Base64.encodeBase64(pin.getBytes());
				String pin1=new String(encode);
				System.out.println(pin1);
				ps.setString(2, pin1);
				cnt=ps.executeUpdate();
				con.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return cnt;
	
	}
	public Long validateUserId(String Userid)
	{
		con=getConnection();
		long customer_id=0;

			try 
			{
				ps=con.prepareStatement("select * from User_Id where User_id=?");
				ps.setString(1, Userid);
				rs=ps.executeQuery();
				if(rs.next())
				{
					customer_id = rs.getLong(2);
				}
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return customer_id;
	
	}
	public int deleteAccountFromTemp(String User_id)
	{
		con=getConnection();
		int cnt=0;
			try 
			{
				ps=con.prepareStatement("delete from UserTempTable where User_id=?");
				ps.setString(1, User_id);
				cnt=ps.executeUpdate();
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return cnt;
		
	}
	public long findCustomerId(String User_id)
	{
		con=getConnection();
		long Customer_id=0;
			try 
			{
				ps=con.prepareStatement("select * from User_Id where User_id=?");
				ps.setString(1, User_id);
				rs=ps.executeQuery();
				if(rs.next())
				{
					Customer_id=rs.getLong(2);
				}
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return Customer_id;		
	}
	public List<LoginInfo> findPassAccNo(long Customer_id)
	{
		con=getConnection();
		List<LoginInfo> lst=new ArrayList<LoginInfo>();
			try 
			{
				ps=con.prepareStatement("select * from LoginInfo1 where Customer_id=?");
				ps.setLong(1, Customer_id);
				rs=ps.executeQuery();
				if(rs.next())
				{
					LoginInfo obj=new LoginInfo();
					obj.setCustomerId(rs.getLong(1));
					obj.setPassword(rs.getString(2));
					obj.setAccountNo(rs.getLong(3));
					obj.setEmailId(rs.getString(4));
					lst.add(obj);
				}
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return lst;
	}
	
	public long findCustomerIdAccount(long accountno) 
	{
		con=getConnection();
		long customerid=0;
			try 
			{
				ps=con.prepareStatement("select * from LoginInfo1 where Acc_no=?");
				ps.setLong(1, accountno);
				rs=ps.executeQuery();
				if(rs.next())
				{
					customerid=rs.getLong(1);
				}
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return customerid;
	}
	public int findAccountno(long accountno) 
	{
		con=getConnection();
		int i=0;
			try 
			{
				ps=con.prepareStatement("select * from LoginInfo1");
				rs=ps.executeQuery();
				while(rs.next())
				{
					long accountno1=rs.getLong(3);
					if(accountno==accountno1)
					{
						i=1;
						return i;
					}
				}
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return i;
	}
	public long findAadharNo(long customerid) 
	{
		con=getConnection();
		long aadharno=0L;
			try 
			{
				ps=con.prepareStatement("select * from AdharNoTable where Customer_id="+customerid);
				rs=ps.executeQuery();
				if(rs.next())
				{
					aadharno=rs.getLong(2);
					System.out.println(aadharno);
				}
				con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return aadharno;
	}
	
	public int checkPin(String username)
	{
		int cnt=0;
		long customer_id=findCustomerId(username);
		System.out.println(customer_id);
		con=getConnection();
		try 
		{
			ps=con.prepareStatement("select * from Transaction_PIN where Customer_id=?");
			ps.setLong(1, customer_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				cnt=1;
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int creditAmount(long transactionid,long accountno,long amount,String fromusername)
	{
		long customer_id= findCustomerIdAccount(accountno);
		int cnt=0;
		try 
		{
			long amount1=getAmount(customer_id);
			long creditamount=amount1+amount;
			DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
			Date dateobj=new Date();
			String date1=dateformat.format(dateobj);
			String status="Credited";
			int cnt1=insertIntoCreditTrasactionAmount(transactionid,customer_id,amount,date1,status,fromusername);
			con=getConnection();
			if(cnt1>0)
			{
				ps=con.prepareStatement("update Account set Acc_Bal="+creditamount+" where Customer_id="+customer_id);
				cnt=ps.executeUpdate();
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int debitAmount(long transactionid,long accountno,long amount,String fromusername)
	{
		int cnt=0;
		try 
		{
			long customer_id= findCustomerId(fromusername);
			long tocustomerid=findCustomerIdAccount(accountno);
			long amount1=getAmount(customer_id);
			long debitamount=amount1-amount;
			DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
			Date dateobj=new Date();
			String date1=dateformat.format(dateobj);
			String status="Debited";
			int cnt1=insertIntoDebitTrasactionAmount(transactionid,tocustomerid,amount,date1,status,fromusername);
			con=getConnection();
			if(cnt1>0)
			{
				ps=con.prepareStatement("update Account set Acc_Bal="+debitamount+" where Customer_id="+customer_id);
				cnt=ps.executeUpdate();
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int insertIntoDebitTrasactionAmount(long transaction_id,long customer_id,long amount,String date1,String status,String fromusername)
	{
		int cnt=0;
		try 
		{
			long customer_id1=findCustomerId(fromusername);
			con=getConnection();
			String discription="Fund Transfered from "+customer_id1+" to "+customer_id;
			ps=con.prepareStatement("insert into TransactionAmountTable values(?,?,?,?,?,?)");
			ps.setLong(1, transaction_id);
			ps.setLong(2, customer_id1);
			ps.setLong(3, amount);
			ps.setString(4, date1);
			ps.setString(5, status);
			ps.setString(6, discription);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int insertIntoCreditTrasactionAmount(long transaction_Id,long customer_id,long amount,String date1,String status,String fromusername)
	{
		int cnt=0;
		try 
		{
			long customer_id1=findCustomerId(fromusername);
			con=getConnection();
			String discription="Fund Transfered from "+customer_id1+" to "+customer_id;
			ps=con.prepareStatement("insert into TransactionAmountTable values(?,?,?,?,?,?)");
			ps.setLong(1, transaction_Id);
			ps.setLong(2 ,customer_id);
			ps.setLong(3, amount);
			ps.setString(4, date1);
			ps.setString(5, status);
			ps.setString(6, discription);
			cnt=ps.executeUpdate();
			con.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int changeMail(String username,String email)
	{
		int cnt=0;
		try 
		{
			long customer_id=findCustomerId(username);
			System.out.println(customer_id);
			long aadharno=findAadharNo(customer_id);
			System.out.println(aadharno);
			con=getConnection();
			ps=con.prepareStatement("update VarientUserInfo set Email_Id =?  where Adhar_no=?");
			ps.setString(1, email);
			ps.setLong(2, aadharno);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int changeMail1(String username,String email)
	{
		int cnt=0;
		try 
		{
			long customer_id=findCustomerId(username);
			con=getConnection();
			ps=con.prepareStatement("update LoginInfo1 set Email_Id =?  where Customer_id=?");
			ps.setString(1, email);
			ps.setLong(2, customer_id);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int changeUserId(String username,String uname)
	{
		int cnt=0;
		try 
		{
			con=getConnection();
			System.out.println(username);
			System.out.println(uname);
			ps=con.prepareStatement("update User_Id set User_id=?  where User_id=?");
			ps.setString(1, uname);
			ps.setString(2, username);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int changePass(String username,String epass)
	{
		int cnt=0;
		try 
		{
			long customer_id=findCustomerId(username);
			con=getConnection();
			ps=con.prepareStatement("update LoginInfo1 set Password=?  where Customer_id=?");
			byte[] encode=Base64.encodeBase64(epass.getBytes());
			String epass1=new String(encode);
			ps.setString(1, epass1);
			ps.setLong(2, customer_id);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int changeMobNo(String username,String emob)
	{
		int cnt=0;
		try 
		{
			long customer_id=findCustomerId(username);
			System.out.println(customer_id);
			long aadharno=findAadharNo(customer_id);
			System.out.println(aadharno);
			con=getConnection();
			ps=con.prepareStatement("update VarientUserInfo set Mob_no=?  where Adhar_no=?");
			long mob=Long.parseLong(emob);
			ps.setLong(1, mob);
			ps.setLong(2, aadharno);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public int changePin(String username,String epin)
	{
		int cnt=0;
		try 
		{
			long customer_id=findCustomerId(username);
			con=getConnection();
			ps=con.prepareStatement("update Transaction_PIN set PIN=?  where Customer_id=?");
			byte[] encode=Base64.encodeBase64(epin.getBytes());
			String epin1=new String(encode);
			ps.setString(1, epin1);
			ps.setLong(2, customer_id);
			cnt=ps.executeUpdate();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cnt;
	}
	public String findEmailId(long customerid)
	{
		con=getConnection();
		String email=null;
		try 
		{
			ps=con.prepareStatement("select * from LoginInfo1 where Customer_id=?");
			ps.setLong(1,customerid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				email=rs.getString(4);
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return email;
	}
	public int checkEmail(String username,String emailid)
	{
		int cnt=0;
		try 
		{
			long customerid=findCustomerId(username);
			String email=findEmailId(customerid);
			if(email.equals(emailid))
			{
				cnt=1;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return cnt;
	}
	
	public long getAmount(long customer_id)
	{
		con=getConnection();
		long amount=0;
		try 
		{
			ps=con.prepareStatement("select * from Account where Customer_id=?");
			ps.setLong(1, customer_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				amount=rs.getLong(3);
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return amount;
	}
	public String searchPin(String username)
	{
		String pin=null;
		long Customer_id=findCustomerId(username);
		con=getConnection();
		try 
		{
			ps=con.prepareStatement("select * from Transaction_PIN where Customer_id=?");
			ps.setLong(1, Customer_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				
				pin=rs.getString(2);
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return pin;
	}
	public List<Transaction> getTransactionHistory(long customerId,String fromdate,String todate)
	{
		List<Transaction> lst=new ArrayList<Transaction>();
		con=getConnection();
		try
		{
			ps=con.prepareStatement("select * from TransactionAmountTable where Customer_id=? and "
					+"DateOfTrasaction between ? and ?");
			ps.setLong(1, customerId);
			ps.setString(2,fromdate);
			ps.setString(3, todate);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Transaction a=new Transaction();
				a.setTransactionId(rs.getLong(1));
				a.setCustomerId(rs.getLong(2));
				a.setAmount(rs.getLong(3));
				a.setDateOftransaction(rs.getString(4));
				a.setStatus(rs.getString(5));
				a.setDiscription(rs.getString(6));
				System.out.println(rs.getLong(3));
				lst.add(a);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
}
