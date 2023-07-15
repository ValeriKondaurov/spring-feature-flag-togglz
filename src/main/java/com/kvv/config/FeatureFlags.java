package com.kvv.config;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum FeatureFlags implements Feature {

  @Label("Price Increase for 01/08/2023")
  PRICE_INCREASE,

  @Label("Start sales")
  START_SALES;
  
}
