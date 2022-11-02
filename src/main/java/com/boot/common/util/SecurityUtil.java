package com.boot.common.util;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.boot.common.exception.ServiceException;
import com.boot.dal.dao.User;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.security.eneity.SysUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author YuanXin
 * @ClassName SecurityUtil
 * @Description TODO
 * @Date 2022/9/11 18:01
 */
public class SecurityUtil {


    public static String getUserId() {
        return getUser().getId();
    }

    public static String getLoveId() {
        String loveId = getUser().getLoveId();
        if (CharSequenceUtil.isBlank(loveId)) {
            throw new ServiceException("您未绑定另一半,请先绑定");
        }
        return loveId;
    }

    public static User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return new User();
        }
        SysUser principal = (SysUser) authentication.getPrincipal();
        if (ObjectUtil.isNull(principal) || ObjectUtil.isNull(principal.getUser())) {
            throw new ServiceException("您未登录,请先登录");
        }
        return principal.getUser();
    }

    public static void clear() {
        SecurityContextHolder.clearContext();
    }

    public static UserBasicInformation getBasicInfo() {
        User user = getUser();
        if (ObjectUtil.isNull(user)) {
            throw new ServiceException("登录异常");
        }
        return new UserBasicInformation().setId(user.getId()).setUsername(user.getUsername()).setAvatar(user.getAvatar());
    }

}
