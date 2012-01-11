/**
 * Copyright 2012 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.ios;

import playn.core.Game;
import playn.core.Json;
import playn.core.Keyboard;
import playn.core.Mouse;
import playn.core.Platform;
import playn.core.PlayN;
import playn.core.RegularExpression;
import playn.core.json.JsonImpl;

/**
 * Provides access to all the PlayN services on iOS.
 */
public class IOSPlatform implements Platform {

  public static void register() {
    PlayN.setPlatform(new IOSPlatform());
  }

  static IOSPlatform instance;

  private IOSAudio audio;
  private IOSGraphics graphics;
  private Json json;
  private IOSKeyboard keyboard;
  private IOSLog log;
  private IOSNet net;
  private IOSPointer pointer;
  private IOSStorage storage;
  private IOSTouch touch;
  private IOSAssetManager assetManager;
  private IOSAnalytics analytics;

  private Game game;

  private IOSPlatform() {
    instance = this;
    audio = new IOSAudio();
    graphics = new IOSGraphics();
    json = new JsonImpl();
    keyboard = new IOSKeyboard();
    log = new IOSLog();
    net = new IOSNet();
    pointer = new IOSPointer();
    touch = new IOSTouch();
    assetManager = new IOSAssetManager();
    analytics = new IOSAnalytics();
    storage = new IOSStorage();
  }

  @Override
  public IOSAssetManager assetManager() {
    return assetManager;
  }

  @Override
  public IOSAnalytics analytics() {
    return analytics;
  }

  @Override
  public IOSAudio audio() {
    return audio;
  }

  @Override
  public IOSGraphics graphics() {
    return graphics;
  }

  @Override
  public Json json() {
    return json;
  }

  @Override
  public IOSKeyboard keyboard() {
    return keyboard;
  }

  @Override
  public IOSLog log() {
    return log;
  }

  @Override
  public IOSNet net() {
    return net;
  }

  @Override
  public void openURL(String url) {
    throw new RuntimeException("TODO");
  }

  @Override
  public Mouse mouse() {
    return null;
  }

  @Override
  public IOSTouch touch() {
    return touch;
  }

  @Override
  public IOSPointer pointer() {
    return pointer;
  }

  @Override
  public float random() {
    return (float) Math.random();
  }

  @Override
  public RegularExpression regularExpression() {
    return null; // new IOSRegularExpression();
  }

  @Override
  public void run(Game game) {
    this.game = game;
    game.init();
  }

  @Override
  public IOSStorage storage() {
    return storage;
  }

  @Override
  public double time() {
    return 0; // System.currentTimeMillis();
  }

  @Override
  public Type type() {
    return Type.IOS;
  }

  void update(float delta) {
    if (game != null) {
      game.update(delta);
    }
  }
}