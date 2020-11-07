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

package cn.biuaxia.code.sport.components.lexin.controller;

import cn.biuaxia.code.sport.components.lexin.forms.RequestSubAndAutoSchForm;
import cn.biuaxia.code.sport.engine.controller.IController;
import cn.biuaxia.code.sport.engine.task.entity.TimedTask;
import cn.biuaxia.code.sport.engine.task.entity.TimedTaskErrorLog;
import cn.biuaxia.code.sport.engine.task.entity.TimedTaskSuccessLog;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.PhoneUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

/**
 * @author biuaxia
 * @date 2020-09-19 03:15:13
 */
@RestController
@RequestMapping("/lexin/step")
@Valid
public class LexinStepController extends IController {

    @GetMapping
    public ResponseEntity<Boolean> step(@NotNull(message = TIPS_USERNAME)
                                        @RequestParam(value = USERNAME_PARAMETER) String username,
                                        @NotNull(message = TIPS_PASSWORD)
                                        @RequestParam(value = PASSWORD_PARAMETER) String password,
                                        @NotNull(message = TIPS_STEP)
                                        @RequestParam(value = STEP_PARAMETER) int step) {
        return ResponseEntity.ok()
                .body(lexinStepService.submitStepAndAutoScheduled(
                        RequestSubAndAutoSchForm.builder()
                                .username(username)
                                .password(password)
                                .wantSteps(step)
                                .build()));
    }

    @GetMapping("list")
    public ResponseEntity<HashMap<String, Page<?>>> list(@RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                                         @RequestParam(defaultValue = DEFAULT_SIZE) int size) {
        Page<TimedTask> timedTaskPage =
                timedTaskMapper.selectPage(
                        new Page<>(page, size),
                        null);

        Page<TimedTaskSuccessLog> successLogPage =
                timedTaskSuccessLogMapper.selectPage(
                        new Page<>(page, size),
                        null);

        Page<TimedTaskErrorLog> errorLogPage =
                timedTaskErrorLogMapper.selectPage(
                        new Page<>(page, size),
                        null);

        HashMap<String, Page<?>> map = new HashMap<>(MapUtil.DEFAULT_INITIAL_CAPACITY);

        // 数据脱敏处理
        List<TimedTask> records = timedTaskPage.getRecords();
        records.forEach(item -> item.setUsername(
                PhoneUtil.hideBetween(
                        item.getUsername())
                        .toString()));
        timedTaskPage.setRecords(records);

        map.put("task", timedTaskPage);
        map.put("success", successLogPage);
        map.put("error", errorLogPage);
        return ResponseEntity.ok().body(map);
    }

}
