/*
 * Copyright 2015 Rik van der Kleij
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powertuple.intellij.haskell.settings

import com.powertuple.intellij.haskell.HaskellNotificationGroup

object HaskellSettingsState {
  private def state = HaskellSettings.getInstance().getState

  def getGhcModPath: Option[String] = {
    createOptionPath(state.ghcModPath, HaskellConfigurable.GhcMod)
  }

  def setGhcModPath(ghcModPath: String) {
    state.ghcModPath = ghcModPath
  }

  def getGhcModiPath: Option[String] = {
    createOptionPath(state.ghcModiPath, HaskellConfigurable.GhcModi)
  }

  def setGhcModiPath(ghcModiPath: String) {
    state.ghcModiPath = ghcModiPath
  }

  def getHaskellDocsPath: Option[String] = {
    createOptionPath(state.haskellDocsPath, HaskellConfigurable.HaskellDocs)
  }

  def setHaskellDocsPath(haskellDocsPath: String) {
    state.haskellDocsPath = haskellDocsPath
  }

  def getHlintPath: Option[String] = {
    createOptionPath(state.hlintPath, HaskellConfigurable.Hlint)
  }

  def setHlintPath(hlintPath: String) {
    state.hlintPath = hlintPath
  }

  def getCabalPath: Option[String] = {
    createOptionPath(state.cabalPath, HaskellConfigurable.Cabal)
  }

  def setCabalPath(cabalPath: String) {
    state.cabalPath = cabalPath
  }

  private def notifyPathIsNotSet(name: String) {
    HaskellNotificationGroup.notifyError("Path to " + name + " is not set")
  }

  private def createOptionPath(path: String, name: String): Option[String] = {
    if (path.isEmpty) {
      notifyPathIsNotSet(name)
      None
    }
    else {
      Option(path)
    }
  }
}
