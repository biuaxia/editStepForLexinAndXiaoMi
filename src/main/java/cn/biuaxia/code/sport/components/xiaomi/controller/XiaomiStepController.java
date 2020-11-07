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

package cn.biuaxia.code.sport.components.xiaomi.controller;

import cn.biuaxia.code.sport.engine.controller.IController;
import cn.biuaxia.code.sport.engine.forms.UserLoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author biuaxia
 * @date 2020-09-19 03:15:13
 */
@RestController
@RequestMapping("/xiaomi/step")
@Valid
public class XiaomiStepController extends IController {

    @GetMapping
    public ResponseEntity<Boolean> step(@NotNull(message = TIPS_USERNAME)
                                        @RequestParam(value = USERNAME_PARAMETER) String username,
                                        @NotNull(message = TIPS_PASSWORD)
                                        @RequestParam(value = PASSWORD_PARAMETER) String password) {
        return ResponseEntity.ok()
                .body(xiaomiStepService.submitStep(
                        UserLoginForm.builder()
                                .username(username)
                                .password(password)
                                .build()));
    }

}
