/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
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
package org.efaps.esjp.loyalty.utils;

import java.util.UUID;

import org.efaps.admin.common.SystemConfiguration;
import org.efaps.admin.program.esjp.EFapsApplication;
import org.efaps.admin.program.esjp.EFapsUUID;
import org.efaps.api.annotation.EFapsSysConfAttribute;
import org.efaps.api.annotation.EFapsSystemConfiguration;
import org.efaps.esjp.admin.common.systemconfiguration.BooleanSysConfAttribute;
import org.efaps.util.cache.CacheReloadException;

@EFapsUUID("96ff8385-58d6-4a91-a528-27522aa705e2")
@EFapsApplication("eFapsApp-Loyalty")
@EFapsSystemConfiguration("4eeea69b-d6c7-47ed-b032-864e992ec215")
public class Loyalty
{

    public static final String BASE = "org.efaps.loyalty.";

    /** Promotions-Configuration. */
    public static final UUID SYSCONFUUID = UUID.fromString("4eeea69b-d6c7-47ed-b032-864e992ec215");

    @EFapsSysConfAttribute
    public static final BooleanSysConfAttribute ACTIVATE = new BooleanSysConfAttribute()
                    .sysConfUUID(Loyalty.SYSCONFUUID)
                    .key(Loyalty.BASE + "Activate")
                    .description("Activate Loyalty.");

    @EFapsSysConfAttribute
    public static final BooleanSysConfAttribute POINTS_ACTIVATE = new BooleanSysConfAttribute()
                    .sysConfUUID(Loyalty.SYSCONFUUID)
                    .key(Loyalty.BASE + "Points.Activate")
                    .description("Activate points payment and program.");

    @EFapsSysConfAttribute
    public static final BooleanSysConfAttribute POINTS_AUTOCREATE = new BooleanSysConfAttribute()
                    .sysConfUUID(Loyalty.SYSCONFUUID)
                    .key(Loyalty.BASE + "Points.AutoCreate")
                    .description("Create points program automatically on first request.");


    public static SystemConfiguration getSysConfig()
        throws CacheReloadException
    {
        return SystemConfiguration.get(SYSCONFUUID);
    }
}
