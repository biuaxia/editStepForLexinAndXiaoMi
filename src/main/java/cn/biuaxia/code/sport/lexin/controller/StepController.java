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

package cn.biuaxia.code.sport.lexin.controller;

import cn.biuaxia.code.sport.lexin.domain.vo.IVO;
import cn.biuaxia.code.sport.lexin.entity.TimedTask;
import cn.biuaxia.code.sport.lexin.entity.TimedTaskErrorLog;
import cn.biuaxia.code.sport.lexin.entity.TimedTaskSuccessLog;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskErrorLogMapper;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskMapper;
import cn.biuaxia.code.sport.lexin.mapper.TimedTaskSuccessLogMapper;
import cn.biuaxia.code.sport.lexin.service.StepService;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * @author biuaxia
 * @date 2020-09-19 03:15:13
 */
@RestController
@RequestMapping("step")
@Valid
public class StepController {

    /**
     * 手机不允许为空
     */
    public static final String TIPS_USERNAME = "手机不允许为空";

    /**
     * 密码不允许为空
     */
    public static final String TIPS_PASSWORD = "密码不允许为空";

    /**
     * 步数不允许为空
     */
    public static final String TIPS_STEP = "步数不允许为空";

    @Resource
    private StepService stepService;

    @Resource
    private TimedTaskMapper timedTaskMapper;

    @Resource
    private TimedTaskSuccessLogMapper timedTaskSuccessLogMapper;

    @Resource
    private TimedTaskErrorLogMapper timedTaskErrorLogMapper;

    @GetMapping
    public ResponseEntity<IVO> step(@NotNull(message = TIPS_USERNAME) @RequestParam(value = "u") String username,
                                    @NotNull(message = TIPS_PASSWORD) @RequestParam(value = "p") String password,
                                    @NotNull(message = TIPS_STEP) @RequestParam(value = "s") String step) {
        return ResponseEntity.ok()
                .body(stepService.submitStep(username, password, Integer.parseInt(step)));
    }

    @GetMapping("list")
    public ResponseEntity<HashMap<String, Page<?>>> list(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Page<TimedTask> timedTaskPage =
                timedTaskMapper.selectPage(new Page<>(page, size), null);
        Page<TimedTaskSuccessLog> successLogPage =
                timedTaskSuccessLogMapper.selectPage(new Page<>(page, size), null);
        Page<TimedTaskErrorLog> errorLogPage =
                timedTaskErrorLogMapper.selectPage(new Page<>(page, size), null);
        HashMap<String, Page<?>> map = new HashMap<>(MapUtil.DEFAULT_INITIAL_CAPACITY);
        map.put("task", timedTaskPage);
        map.put("success", successLogPage);
        map.put("error", errorLogPage);
        return ResponseEntity.ok()
                .body(map);
    }

}
