/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/fenixsoft
 */

package com.evil.highconcurrentinventorydeduction.resource;

import com.evil.highconcurrentinventorydeduction.domain.Advertisement;
import com.evil.highconcurrentinventorydeduction.repository.AdvertisementRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 广告相关的资源
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/7 10:48
 **/
@RequestMapping("/advertisements")
@RestController
@Produces(MediaType.APPLICATION_JSON)
public class AdvertisementResource {

    @Resource
    AdvertisementRepository repository;

    @GetMapping
    @Cacheable("resource.advertisements")
    public Iterable<Advertisement> getAllAdvertisements() {
        return repository.findAll();
    }
}