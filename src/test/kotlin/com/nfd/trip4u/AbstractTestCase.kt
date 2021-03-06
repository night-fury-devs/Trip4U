package com.nfd.trip4u

import com.nfd.trip4u.configuration.ThymeleafConfiguration
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Author: Alexey Kleschikov
 * Date: 07 Jun 2016
 * Time: 22:07
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(Application::class, ThymeleafConfiguration::class))
abstract class AbstractTestCase