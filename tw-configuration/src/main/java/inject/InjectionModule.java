package inject;

import com.google.inject.AbstractModule;
import com.twanalyzer.bus.MessageBusProvider;
import com.twanalyzer.bus.MessageBusRepo;
import com.twanalyzer.db.StreamDataRepo;
import com.twanalyzer.repasitory.MessageBus;
import com.twanalyzer.repasitory.StreamData;
import com.twanalyzer.wrapper.Logger;
import com.twanalyzer.wrapper.LoggerWrapper;


/**
 * Created by lilit.
 */
public class InjectionModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Logger.class).toInstance(LoggerWrapper.getInstance());
        bind(StreamData.class).toInstance(StreamDataRepo.getInstance());
        bind(MessageBus.class).toInstance(MessageBusRepo.getInstance());

    }
}