rootProject.name = "Dormitory-Management-AOS"
include(":app")
include(":common")
include(":network")
project(":common").projectDir = File(rootDir, "modules/common/")
project(":network").projectDir = File(rootDir, "modules/network/")
