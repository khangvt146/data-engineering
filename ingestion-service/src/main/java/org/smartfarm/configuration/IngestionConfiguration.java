package org.smartfarm.configuration;

import org.smartfarm.adapter.in.IncomingEventAdapter;
import org.smartfarm.adapter.out.PushAlarmKafka;
import org.smartfarm.adapter.out.SaveEventAdapter;
import org.smartfarm.application.port.in.IncomingEventPort;
import org.smartfarm.application.port.out.SaveEventPort;
import org.smartfarm.application.port.out.SendAlarmPort;
import org.smartfarm.application.service.CheckConditionService;
import org.smartfarm.application.service.StoreEventService;
import org.smartfarm.application.usecase.CheckConditionUsecase;
import org.smartfarm.application.usecase.StoreEventUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IngestionConfiguration {
    @Bean
    StoreEventUsecase storeEventUsecase(){
        return new StoreEventService();
    }

    @Bean
    CheckConditionUsecase checkConditionUsecase(){
        return new CheckConditionService();
    }

    @Bean
    IncomingEventPort incomingEventPort(){
        return new IncomingEventAdapter();
    }

    @Bean
    SaveEventPort saveEventPort() {
        return new SaveEventAdapter();
    }

    @Bean
    SendAlarmPort sendAlarmPort() {
        return new PushAlarmKafka();
    }

}
