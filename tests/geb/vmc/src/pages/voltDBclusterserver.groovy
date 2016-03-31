/* This file is part of VoltDB.
 * Copyright (C) 2008-2016 VoltDB Inc.
 *
 * This file contains original code and/or modifications of original code.
 * Any modifications made by VoltDB Inc. are licensed under the following
 * terms and conditions:
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */package vmcTest.pages

import geb.Module
import java.util.List;
import java.util.Map;

import geb.*
import geb.navigator.Navigator
import geb.waiting.WaitTimeoutException

import org.openqa.selenium.JavascriptExecutor

/**
 * Created by lavthaiba on 2/19/2015.
 */
class voltDBclusterserver extends Module {
    static content = {
        serverbutton                { $("#serverName") }
        serverconfirmation          { $("#serverConfigAdmin > div > div.slide-pop-title > div.icon-server.searchLeft.searchLeftAdmin") }
        deerwalkserver3stopbutton   {$("#stopServer_deerwalk3")}
        deeerwalkservercancelbutton {$("#StopConfirmCancel")}
        deerwalkserverstopok        { $("#StopConfirmOK")}

        deerwalkserver4stopbutton   {$("#stopServer_deerwalk4")}

        //DBmonitor part for server
        dbmonitorbutton{$("#navDbmonitor > a")}
        clusterserverbutton{$("#btnPopServerList")}
        servernamefourthbtn{$("#serversList > li:nth-child(1) > a")}
        servernamesecondbtn{$("#serversList > li:nth-child(2) > a")}
        servernamethirdbtn{$("#serversList > li:nth-child(3) > a")}
        serveractivechk    {$("#serversList > li.active.monitoring > a")}
        serversearch{$("input", type: "text", id: "popServerSearch")}
        checkserverTitle{$("#popServerList > div > div.slide-pop-title > div.icon-server.searchLeft")}
        setthreshhold{$("#threshold")}
        clickthreshholdset{$("#saveThreshold")}

        // dbmonitor graph
        servercpudaysmin{$("#visualisationCpu > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        servercpudaysmax{$("#visualisationCpu > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        servercpuminutesmin{$("#visualisationCpu > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        servercpuminutemax{$("#visualisationCpu > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        servercpusecondmin{$("#visualisationCpu > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        servercpusecondmax{$("#visualisationCpu > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}

        selecttypeindrop{$("#graphView")}
        selecttypedays{$("#graphView > option:nth-child(3)")}
        selecttypemin{$("#graphView > option:nth-child(2)")}
        selecttypesec{$("#graphView > option:nth-child(1)")}

        serverramdaysmin{$("#visualisationRam > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        serverramdaysmax{$("#visualisationRam > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        serverramsecondmin{$("#visualisationRam > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        serverramsecondmax{$("#visualisationRam > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        serverramminutesmin{$("#visualisationRam > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        serverramminutesmax{$("#visualisationRam > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}

        clusterlatencydaysmin{$("#visualisationLatency > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        clusterlatencydaysmax{$("#visualisationLatency > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        clusterlatencysecondmin{$("#visualisationLatency > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        clusterlatencysecondmax{$("#visualisationLatency > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        clusterlatencyminutesmin{$("#visualisationLatency > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        clusterlatencyminutesmax{$("#visualisationLatency > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}

        clustertransactiondaysmin{$("#visualisationTransaction > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        clustertransactiondaysmax{$("#visualisationTransaction > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        clustertransactionsecondmin{$("#visualisationTransaction > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        clustertransactionsecondmax{$("#visualisationTransaction > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
        clustertransactionminutesmin{$("#visualisationTransaction > g > g > g.nv-x.nv-axis > g > g:nth-child(2) > text")}
        clustertransactionminutesmax{$("#visualisationTransaction > g > g > g.nv-x.nv-axis > g > g:nth-child(3) > text")}
    }

}
