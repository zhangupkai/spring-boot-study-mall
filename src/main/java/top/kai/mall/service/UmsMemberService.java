package top.kai.mall.service;

import top.kai.mall.common.api.CommonResult;

/**
 * @Description 会员管理Service
 * @Author Kai
 * @Date 2020/12/29 19:49
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult<?> generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult<?> verifyAuthCode(String telephone, String authCode);
}
