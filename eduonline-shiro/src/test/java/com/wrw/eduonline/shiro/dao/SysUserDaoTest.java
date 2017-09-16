package com.wrw.eduonline.shiro.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wrw.eduonline.shiro.entity.SysUserEntity;


public class SysUserDaoTest {
	
	private SysUserDao sysUserDaoMapper;

	@Before
	public void setUp() throws Exception {
		InputStream fis = null;
        InputStream inputStream = null;
        try {
            //创建Properties对象
            Properties prop = new Properties();
            //创建输入流，指向配置文件,getResourceAsStream可以从classpath加载资源
            fis= Resources.getResourceAsStream("jdbc.properties");
            //加载属性文件
            prop.load(fis);
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //build的第二个参数对应mybatis.xml配置文件的<environment id="development">标签的id，
            //其中后面两个参数可选，若第二个参数不写则默认为"development"
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"development",prop);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //StuScoreDao.class与配置文件StuMapper的namespace对应
            sysUserDaoMapper = sqlSession.getMapper(SysUserDao.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void save() {
		
		SysUserEntity user = new SysUserEntity();
		user.setUsername("wrw");
		user.setPassword("123456");
		user.setEmail("wrw@email.com");
		user.setMobile("15622283782");
//		user.setStatus();
		user.setCreateTime(new Date());
		user.setModifiedTime(new Date());
		
		this.sysUserDaoMapper.save(user);
	}
}
