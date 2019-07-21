/*
 * Copyright (c) 2018. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tobiasfried.phosphor

import com.github.javiersantos.piracychecker.PiracyChecker
import com.tobiasfried.phosphor.BuildConfig
import jahirfiquitiva.libs.blueprint.models.NavigationItem
import jahirfiquitiva.libs.blueprint.ui.activities.BottomNavigationBlueprintActivity

/**
 * You can choose between:
 * - DrawerBlueprintActivity
 * - BottomNavigationBlueprintActivity
 */
class MainActivity : BottomNavigationBlueprintActivity() {
    /**
     * These things here have the default values. You can delete the ones you don't want to change
     * and/or modify the ones you want to.
     */
    override var donationsEnabled = true

    override fun amazonInstallsEnabled(): Boolean = false
    override fun checkLPF(): Boolean = true
    override fun checkStores(): Boolean = true

    /**
     * This is your app's license key. Get yours on Google Play Dev Console.
     * Default one isn't valid and could cause issues in your app.
     */
    override fun getLicKey(): String? = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvebgRNKRC0cCrQUbqAVbqIZMnwmvia2MIIIWaAws9mb5tDuNtamFGEgs/sGwGAzztyBitSN3dLR0VZ5r+BbL3z/GklNpUeIuT7FkPANBSv2PyiDjNGpqBjeh4Q2fesWDGjqV55pqF7w6WLqLtDv5a/Mb/ZpUqPEfIMxL64d6pZTpCbvukGQccJFtBuYX5vfD0AKb9+lAMVaCxSD93L8Mjskpp4dpaaV2w4riykWfAi5Fh8fxPbq3o4pb9X5m67DUkgBWxier36tgZJo3kaUnEgoDVDt3tcXj2tMBO3XSB0pngS3ASg8a2Y4LukpwsKPZ5FurRhpSga5wJeQ/LjnQzwIDAQAB"

    /**
     * This is the license checker code. Feel free to create your own implementation or
     * leave it as it is.
     * Anyways, keep the 'destroyChecker()' as the very first line of this code block
     * Return null to disable license check
     */
    override fun getLicenseChecker(): PiracyChecker? {
        destroyChecker() // Important
        return if (BuildConfig.DEBUG) null
        else return super.getLicenseChecker()
    }

    /**
     * These are the main items that will be shown in the navigation drawer or bottom navigation.
     * Remove the ones you don't want to show.
     * You can also organize them however you want.
     * Templates (Zooper & Kustom), Credits, Settings and Help sections are added by default. So don't worry about those.
     */
    override fun getNavigationItems(): Array<NavigationItem> {
        return arrayOf(
            NavigationItem.HOME,
            NavigationItem.ICONS,
            NavigationItem.WALLPAPERS,
            NavigationItem.APPLY,
            NavigationItem.REQUESTS)
    }

    /**
     * When set to true, the app will print warnings for duplicated components or missing icons from
     * appfilter.xml
     *
     * If set to BuildConfig.DEBUG, the app will print the warnings only while debugging the app
     * (This is the safest option, so the apk you publish in PlayStore doesn't print them)
     */
    override fun debug(): Boolean = BuildConfig.DEBUG
}
