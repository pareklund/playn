/**
 * Copyright 2010 The ForPlay Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package forplay.core;

/**
 * Generic platform interface. New platforms are defined as implementations of this interface.
 */
public interface Platform {

  Audio audio();

  Graphics graphics();
  
  AssetManager assetManager();

  void init();

  Json json();

  Keyboard keyboard();

  Log log();

  Net net();

  Pointer pointer();

  /**
   * Return the mouse if it is supported, or null otherwise.
   * 
   * @return the mouse if it is supported, or null otherwise.
   */
  Mouse mouse();

  Storage storage();
  
  Analytics analytics();

  float random();

  void run(Game game);

  double time();

  RegularExpression regularExpression();

  void openURL(String url);
}
