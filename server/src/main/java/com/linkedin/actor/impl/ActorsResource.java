/*
   Copyright (c) 2012 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.linkedin.actor.impl;

import com.github.javafaker.Faker;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.linkedin.actor.Actor;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Very simple RestLi Resource that serves up a fortune cookie.
 *
 * @author Doug Young
 */
@RestLiCollection(name = "actors", namespace = "com.linkedin.actor")

public class ActorsResource extends CollectionResourceTemplate<Long, Actor>
{
  static List<String> genders = new ArrayList<String>();
  static {
    genders.add("male");
    genders.add("female");
    genders.add("undisclosed");
  }
  static List<Actor> actorList = new ArrayList<Actor>();
  static {
    for (int i = 1; i < 6; i++) {
      actorList.add(createActor(i));
    }
  }

  @Override
  public Actor get(Long key)
  {
    Predicate<Actor> byId = actor -> actor.getId().equals(key.toString());
    return FluentIterable.from(actorList)
        .filter(byId)
        .first()
        .get();
  }

  private static Actor createActor(int actorId)
  {

    Faker faker = new Faker();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(actorId);
    return new Actor()
        .setId(stringBuilder.toString())
        .setName(faker.name().fullName())
        .setGender(randomGender())
        .setBio(faker.lorem().paragraph());
  }

  private static String randomGender() {
    Random generator = new Random();
    int randomIndex = generator.nextInt(3);
    return genders.get(randomIndex);
  }
}
