package org.smartfarm.application.port.out;

import org.smartfarm.application.domain.TsEvent;

public interface SendAlarmPort {
    void sendAlarm(TsEvent event);
}
