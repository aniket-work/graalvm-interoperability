package com.aniket.graalvm.interoperability.model;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name("YourCustomEventName")
@Label("Your Custom Event Label")
public class StartupEvent extends Event {

    public String key;
}
