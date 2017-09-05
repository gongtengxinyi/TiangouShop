package com.tiangou.realm;  
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;  
  
/** 
 * �Զ����ָ��Shiro��֤�û���¼���� 
 * @see �ڱ����ж�����2���û�:jadyer������,jadyer����admin��ɫ��admin:manageȨ��,���񲻾����κν�ɫ��Ȩ�� 
 * @create
 * @author ����<http://blog.csdn.net/jadyer> 
 */  
public class MyRealm extends AuthorizingRealm {  
    /** 
     * Ϊ��ǰ��¼��Subject�����ɫ��Ȩ�� 
     * @see ������:�����и÷����ĵ���ʱ��Ϊ����Ȩ��Դ������ʱ 
     * @see ������:����ÿ�η�������Ȩ��Դʱ����ִ�и÷����е��߼�,�����������Ĭ�ϲ�δ����AuthorizationCache 
     * @see ���˸о���ʹ����Spring3.1��ʼ�ṩ��ConcurrentMapCache֧��,����������Ƿ�����AuthorizationCache 
     * @see ����˵��������ݿ��ȡȨ����Ϣʱ,��ȥ����Spring3.1�ṩ�Ļ���,����ʹ��Shior�ṩ��AuthorizationCache 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){  
        //��ȡ��ǰ��¼���û���,�ȼ���(String)principals.fromRealm(this.getName()).iterator().next()  
        String currentUsername = (String)super.getAvailablePrincipal(principals);  
//      List<String> roleList = new ArrayList<String>();  
//      List<String> permissionList = new ArrayList<String>();  
//      //�����ݿ��л�ȡ��ǰ��¼�û�����ϸ��Ϣ  
//      User user = userService.getByUsername(currentUsername);  
//      if(null != user){  
//          //ʵ����User�а������û���ɫ��ʵ������Ϣ  
//          if(null!=user.getRoles() && user.getRoles().size()>0){  
//              //��ȡ��ǰ��¼�û��Ľ�ɫ  
//              for(Role role : user.getRoles()){  
//                  roleList.add(role.getName());  
//                  //ʵ����Role�а����н�ɫȨ�޵�ʵ������Ϣ  
//                  if(null!=role.getPermissions() && role.getPermissions().size()>0){  
//                      //��ȡȨ��  
//                      for(Permission pmss : role.getPermissions()){  
//                          if(!StringUtils.isEmpty(pmss.getPermission())){  
//                              permissionList.add(pmss.getPermission());  
//                          }  
//                      }  
//                  }  
//              }  
//          }  
//      }else{  
//          throw new AuthorizationException();  
//      }  
//      //Ϊ��ǰ�û����ý�ɫ��Ȩ��  
//      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
//      simpleAuthorInfo.addRoles(roleList);  
//      simpleAuthorInfo.addStringPermissions(permissionList);  
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
        //ʵ���п��ܻ�������ע�͵����������ݿ�ȡ��  
        if(null!=currentUsername && "jadyer".equals(currentUsername)){  
            //���һ����ɫ,�������������ϵ����,����֤�����û�ӵ��admin��ɫ    
            simpleAuthorInfo.addRole("admin");  
            //���Ȩ��  
            simpleAuthorInfo.addStringPermission("admin:manage");  
            System.out.println("��Ϊ�û�[jadyer]������[admin]��ɫ��[admin:manage]Ȩ��");  
            return simpleAuthorInfo;  
        }else if(null!=currentUsername && "����".equals(currentUsername)){  
            System.out.println("��ǰ�û�[����]����Ȩ");  
            return simpleAuthorInfo;  
        }  
        //���÷���ʲô������ֱ�ӷ���null�Ļ�,�ͻᵼ���κ��û�����/admin/listUser.jspʱ�����Զ���ת��unauthorizedUrlָ���ĵ�ַ  
        //���applicationContext.xml�е�<bean id="shiroFilter">������  
        return null;  
    }  
  
      
    /** 
     * ��֤��ǰ��¼��Subject 
     * @see ������:�����и÷����ĵ���ʱ��ΪLoginController.login()������ִ��Subject.login()ʱ 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  
        //��ȡ�����û��������������  
        //ʵ�������authcToken�Ǵ�LoginController����currentUser.login(token)��������  
        //����token�����ö���һ����,��������org.apache.shiro.authc.UsernamePasswordToken@33799a1e  
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        System.out.println("��֤��ǰSubjectʱ��ȡ��tokenΪ" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
//      User user = userService.getByUsername(token.getUsername());  
//      if(null != user){  
//          AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());  
//          this.setSession("currentUser", user);  
//          return authcInfo;  
//      }else{  
//          return null;  
//      }  
        //�˴�����ȶ�,�ȶԵ��߼�Shiro����,����ֻ�践��һ����������ص���ȷ����֤��Ϣ  
        //˵���˾��ǵ�һ���������¼�û���,�ڶ���������Ϸ��ĵ�¼����(�����Ǵ����ݿ���ȡ����,������Ϊ����ʾ��Ӳ������)  
        //����һ��,�����ĵ�¼ҳ���Ͼ�ֻ������ָ�����û����������ͨ����֤  
        if("jadyer".equals(token.getUsername())){  
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("jadyer", "jadyer", this.getName());  
            this.setSession("currentUser", "jadyer");  
            return authcInfo;  
        }else if("����".equals(token.getUsername())){  
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("����", "xuanyu", this.getName());  
            this.setSession("currentUser", "����");  
            return authcInfo;  
        }  
        //û�з��ص�¼�û�����Ӧ��SimpleAuthenticationInfo����ʱ,�ͻ���LoginController���׳�UnknownAccountException�쳣  
        return null;  
    }  
      
      
    /** 
     * ��һЩ���ݷŵ�ShiroSession��,�Ա��������ط�ʹ�� 
     * @see ����Controller,ʹ��ʱֱ����HttpSession.getAttribute(key)�Ϳ���ȡ�� 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            System.out.println("SessionĬ�ϳ�ʱʱ��Ϊ[" + session.getTimeout() + "]����");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  
}