package org.smartfarm.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smartfarm.application.port.out.SaveEventPort;
import org.smartfarm.infrastructure.database.entity.*;
import org.smartfarm.infrastructure.database.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RequiredArgsConstructor
public class SaveEventAdapter implements SaveEventPort {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    @Autowired
    private LightRepository lightRepository;

    @Autowired
    private PhRepository phRepository;

    @Autowired
    private PressureRepository pressureRepository;

    @Autowired
    private SalinityRepository salinityRepository;

    @Override
    public void saveTempEvent(TempRecord tempInfo) {
        temperatureRepository.save(tempInfo);
    }

    @Override
    public void saveHumidityEvent(HumidityRecord humidityInfo){humidityRepository.save(humidityInfo);}

    @Override
    public void saveLightEvent(LightRecord lightInfo){lightRepository.save(lightInfo);}

    @Override
    public void savePressureEvent(PressureRecord pressureInfo){pressureRepository.save(pressureInfo);}

    @Override
    public void saveSalinityEvent(SalinityRecord salinityInfo){salinityRepository.save(salinityInfo);}

    @Override
    public void savePhEvent(PhRecord phInfo){phRepository.save(phInfo);}
}
