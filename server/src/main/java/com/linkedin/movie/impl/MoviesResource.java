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

package com.linkedin.movie.impl;

import com.github.javafaker.Faker;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.linkedin.movie.Movie;
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
@RestLiCollection(name = "movies", namespace = "com.linkedin.movie")

public class MoviesResource extends CollectionResourceTemplate<Long, Movie>
{
  static List<String> ratings = new ArrayList<String>();
  static {
    ratings.add("G");
    ratings.add("PG");
    ratings.add("PG13");
    ratings.add("R");
  }
  static List<Movie> movieList = new ArrayList<Movie>();
  static {
    for (int i = 1; i < 6; i++) {
      movieList.add(createMovie(i));
    }
  }

  @Override
  public Movie get(Long key)
  {
    Predicate<Movie> byId = movie -> movie.getId().equals(key.toString());
    return FluentIterable.from(movieList)
        .filter(byId)
        .first()
        .get();
  }

  private static Movie createMovie(int movieId)
  {
    Faker faker = new Faker();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(movieId);
    return new Movie()
        .setId(stringBuilder.toString())
        .setTitle(faker.book().title())
        .setSynopsis(faker.lorem().paragraph())
        .setRelease_date(faker.date().toString())
        .setLength(faker.number().numberBetween(30, 250))
        .setRating(randomRating())
        .setStars(faker.number().numberBetween(1, 5));
  }

  private static String randomRating()
  {
    Random generator = new Random();
    int randomIndex = generator.nextInt(3);
    return ratings.get(randomIndex);
  }
}
