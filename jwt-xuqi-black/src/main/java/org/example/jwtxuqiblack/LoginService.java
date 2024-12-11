package org.example.jwtxuqiblack;

/**
 * @author redA
 * @时间: 2024年11月20日 下午4:52
 * @描述：
 */
public interface LoginService {
    /**
     * 校验token是不是有效
     * @param token
     * @return
     */
    boolean verify(String token);
     /**
     * 刷新token有效期
     *
     * @param token
     */
    void renewalTokenIfNecessary(String token);
    /**
     * 登录成功，获取token
     *
     * @param uid
     * @return 返回token
     */
    String login(Long uid);

    /**
     * 如果token有效，返回uid
     *
     * @param token
     * @return
     */
    Long getValidUid(String token);
}
