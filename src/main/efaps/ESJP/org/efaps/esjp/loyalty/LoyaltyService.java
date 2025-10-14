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
package org.efaps.esjp.loyalty;

import java.util.ArrayList;
import java.util.List;

import org.efaps.admin.program.esjp.EFapsApplication;
import org.efaps.admin.program.esjp.EFapsUUID;
import org.efaps.admin.program.esjp.Listener;
import org.efaps.esjp.loyalty.listener.IOnQuery;
import org.efaps.esjp.loyalty.pojo.PointsBalance;
import org.efaps.util.EFapsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EFapsUUID("04a0d125-b620-4308-bfb3-45f80c176951")
@EFapsApplication("eFapsApp-Loyalty")
public class LoyaltyService
{
    private static final Logger LOG = LoggerFactory.getLogger(LoyaltyService.class);

    public List<PointsBalance> queryBalance4Contact(final String identifier)
        throws EFapsException
    {
        final var dtos = new ArrayList<PointsBalance>();
        LOG.info("Query Programs for contact with identifier: {}", identifier);
        for (final IOnQuery listener : Listener.get().<IOnQuery>invoke(IOnQuery.class)) {
            dtos.addAll(listener.queryBalance4Contact(identifier));
        }
        return dtos;
    }

    public void accumulatePoints() {

    }
}
