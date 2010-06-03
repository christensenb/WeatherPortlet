/* Copyright 2008 The JA-SIG Collaborative. All rights reserved.
 *  See license distributed with this file and
 *  available online at http://www.uportal.org/license.html
 */

package org.jasig.portlet.weather.dao;

import java.util.Collection;

import org.jasig.portlet.weather.domain.Location;
import org.jasig.portlet.weather.domain.Weather;
import org.springmodules.cache.annotations.Cacheable;

/**
 * Weather data access interface. Implement this interface to retrieve weather
 * information from source.
 * 
 * @author Dustin Schultz
 * @version $Id$
 */
public interface IWeatherDao {

	/**
	 * Gets the weather from an implemented source.
	 * 
	 * @param locationCode
	 *            A string value representing the location to retrieve weather
	 *            from.
	 * @param metric
	 *            A boolean value representing metric or not.
	 * @return A Weather object representing the current weather and an optional
	 *         forecast.
	 */
	@Cacheable(modelId="weatherDataCacheModel")
	public Weather getWeather(String locationCode, Boolean metric);

	/**
	 * @param location
	 *            A String representing a location to find
	 * @return A collection of locations representing the possible location or
	 *         an empty or null collection representing location not found.
	 */
	@Cacheable(modelId="weatherSearchCacheModel")
	public Collection<Location> find(String location);

}