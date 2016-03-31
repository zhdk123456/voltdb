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
 * Created by anrai on 2/12/15.
 */

class Header extends Module {
    static content = {
        banner                      { $("#headerMain") }
        image                       { $(class:"logo") }
        tabDBMonitor                { $("#navDbmonitor") }
        tabAdmin                    { $("#navAdmin") }
        tabSchema                   { $("#navSchema") }
        tabSQLQuery                 { $("#navSqlQuery") }
        usernameInHeader            { $("#btnlogOut") }
        logout                      { $("#logOut") }
        showHelp                    { $("#showMyHelp") }
        help                        { $("#userSection > li:nth-child(4) > div > ul > li > a") }
        popup                       { $(class:"popup_content10") }
        popupTitle                  { $(class:"overlay-title helpIcon ", text:"Help") }
        popupClose                  { $(class:"popup_close") }
        logoutPopup                 { $(class:"popup_content2") }
        logoutPopupTitle            { $(class:"overlay-title ") }
        logoutPopupOkButton         { $("#A1") }
        logoutPopupCancelButton     { $("#btnCancel") }
    }

    def String getUsername() {
        BufferedReader br = new BufferedReader(new FileReader("src/resources/users.txt"))
        String user

        while((user = br.readLine()) != "#username") {
        }

        user = br.readLine()

        return user
    }

    def String getPassword() {
        BufferedReader br = new BufferedReader(new FileReader("src/resources/users.txt"))
        String password

        while((password = br.readLine()) != "#password") {
        }

        password = br.readLine()

        return password
    }

    def boolean checkShowHelp() {
        waitFor(30) { help.isDisplayed() }
        help.click()
        waitFor(30) { showHelp.isDisplayed() }
    }

    def boolean checkIfHelpIsOpen() {
        checkShowHelp()
        showHelp.click()

        popupTitle.isDisplayed()
        popupClose.isDisplayed()
        popupTitle.text().toLowerCase().contains("help".toLowerCase());
    }
}
