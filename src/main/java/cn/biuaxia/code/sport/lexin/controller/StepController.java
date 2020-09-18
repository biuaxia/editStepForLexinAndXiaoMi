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
import cn.biuaxia.code.sport.lexin.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author biuaxia
 * @date 2020-09-19 03:15:13
 */
@RestController
@RequestMapping("step")
public class StepController {

    /**
     * 请求接口默认的乐心手机
     */
    public static final String USERNAME = "17608348340";

    /**
     * 请求接口默认的乐心密码
     */
    public static final String PASSWORD = "biuaxia666";

    /**
     * 请求接口默认的刷取步数
     */
    public static final String STEP = "98765";

    @Autowired
    private StepService stepService;

    @GetMapping
    public ResponseEntity<IVO> step(@RequestParam(value = "u", defaultValue = USERNAME) String username,
                                    @RequestParam(value = "p", defaultValue = PASSWORD) String password,
                                    @RequestParam(value = "s", defaultValue = STEP) String step) {

        return ResponseEntity.ok()
                .body(stepService.submitStep(username, password, Integer.parseInt(step)));
    }

}
