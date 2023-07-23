package com.nntk.ddd.domain.impl;

import com.nntk.ddd.domain.MqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MqServiceImpl implements MqService {
    @Override
    public void send(String message) {


    }
}
