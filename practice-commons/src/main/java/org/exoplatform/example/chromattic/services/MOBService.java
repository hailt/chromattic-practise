/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.example.chromattic.services;

import org.chromattic.api.Chromattic;
import org.chromattic.api.ChromatticSession;
import org.exoplatform.commons.chromattic.ChromatticManager;
import org.exoplatform.example.chromattic.entities.Model;

/**
 * Created by The eXo Platform SAS
 * Author : Lai Trung Hieu
 *          hieult@exoplatform.com
 * Apr 16, 2012  
 */
public class MOBService {
  
  private ChromatticManager cManager;
  
  public MOBService(ChromatticManager cManager) {
    this.cManager = cManager;
  }
  
  /**
   * Get Chromattic manager object
   * @return the cManager
   */
  public ChromatticManager getcManager() {
    return cManager;
  }
  
  /**
   * Get Chromattic session
   * @return chromattic session
   */
  public ChromatticSession getSession() {
    return cManager.getLifeCycle("lab").getContext().getSession();
  }
  
  /**
   * Get model
   * @return model
   */
  public Model getModel() {
    Chromattic chromattic = cManager.getLifeCycle("lab").getChromattic();
    ChromatticSession chromeSession = chromattic.openSession();
    return new Model(chromeSession);
  }

}
