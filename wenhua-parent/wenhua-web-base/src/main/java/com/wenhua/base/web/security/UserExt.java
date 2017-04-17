package com.wenhua.base.web.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Spring Security UserDetail extension.
 * @author zhuzhaohua
 *
 */
public class UserExt extends User {

	private static final long serialVersionUID = 1L;

    private String empName;
//    private Long departmentId;
    private String id;
    
    public UserExt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserExt(String username, String password, boolean enabled,
                   boolean accountNonExpired, boolean credentialsNonExpired,
                   boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     * 是否是某个角色
     * @param roleCode 角色代码
     * @return
     */
    public boolean hasRole(String roleCode) {
    	if(null == roleCode || 0 == roleCode.length()) return false;
    	Collection<GrantedAuthority> authorities = this.getAuthorities();
    	if(null == authorities || 0 == authorities.size()) {
    		return false;
    	}
    	
    	for(GrantedAuthority ga : authorities) {
    		if(roleCode.equalsIgnoreCase(ga.getAuthority()) 
//    				|| HyRole.ROLE_SUPER.equalsIgnoreCase(ga.getAuthority())
    				) {
    			return true;
    		}
    	}
    	return false;
    }
    
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Long getDepartmentId() {
//		return departmentId;
//	}
//
//	public void setDepartmentId(Long departmentId) {
//		this.departmentId = departmentId;
//	}

}