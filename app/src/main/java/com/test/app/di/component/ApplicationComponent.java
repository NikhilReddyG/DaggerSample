package com.test.app.di.component;

import android.content.Context;

import com.test.app.MyApplication;
import com.test.app.apiservice.APIInterface;
import com.test.app.di.module.ContextModule;
import com.test.app.di.module.RetrofitModule;
import com.test.app.di.qualifier.ApplicationContext;
import com.test.app.di.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);
}
