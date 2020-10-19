/*
 *
 *  * Copyright 2020-2030 biuaxia(https://github.com/biuaxia)
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package cn.biuaxia.code.sport.lexin.service;

import cn.biuaxia.code.sport.lexin.domain.bo.LoginBO;
import cn.biuaxia.code.sport.lexin.domain.vo.IVO;
import cn.biuaxia.code.sport.lexin.domain.vo.SubmitVO;
import cn.biuaxia.code.sport.lexin.entity.TimedTask;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskMapper;
import cn.biuaxia.code.sport.lexin.utils.StepUtils;
import cn.biuaxia.code.sport.lexin.utils.UserInfoUtils;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 步数接口实现类
 *
 * @author biuaxia
 * @date 2020-09-19 03:28:35
 */
@Service
public class StepServiceImpl implements StepService {

    public static final String SUBMIT = "提交";
    public static final String SUCCESS = "成功";
    public static final String FAILURE = "失败";

    @Resource
    private UserInfoUtils userInfoUtils;

    @Resource
    private StepUtils stepUtils;

    @Resource
    private TimedTaskMapper timedTaskMapper;

    @Override
    public IVO submitStep(String username, String password, Integer step) {
        final LoginBO.DataDTO userInfo = userInfoUtils.getUserInfo(username, password);
        final String userId = userInfo.getUserId();
        final Boolean submitResult = stepUtils.submit(userId, step);
        if (!submitResult) {
            return SubmitVO.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .msg(SubmitVO.SUBMIT + SubmitVO.FAILURE)
                    .build();
        }
        final SubmitVO submitVO = SubmitVO.builder().build();
        submitVO.setData(
                SubmitVO.Data.builder()
                        .userId(userId)
                        .username(username)
                        .step(step)
                        .build());

        password = SecureUtil.md5(password);

        TimedTask dbTimedTask = timedTaskMapper.selectOne(new LambdaQueryWrapper<TimedTask>()
                .eq(TimedTask::getUsername, username)
                .eq(TimedTask::getPassword, password));
        if (ObjectUtil.isEmpty(dbTimedTask)) {
            timedTaskMapper.insert(TimedTask.builder()
                    .username(username)
                    .password(password)
                    .step(step)
                    .build());
        } else {
            if (ObjectUtil.isNotEmpty(dbTimedTask.getStep()) && !step.equals(dbTimedTask.getStep())) {
                dbTimedTask.setStep(step);
                timedTaskMapper.updateById(dbTimedTask);
            }
        }
        return submitVO;
    }

}
