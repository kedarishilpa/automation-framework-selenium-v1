# 🚀 Scalable Java Test Automation Framework

## 📌 Overview
A **scalable Java-based Test Automation Framework** powered by **Maven** and **TestNG**, seamlessly integrated with **LambdaTest** for cloud execution.  
Built for **cross-browser compatibility**, **headless execution**, and **parallel scalability**, this framework accelerates testing cycles and improves coverage.

---

## ✨ Features
- ✅ **Java + Maven** for build automation and dependency management  
- ✅ **TestNG** for testing and reporting  
- ✅ **LambdaTest integration** for cloud-based execution  
- ✅ **Cross-browser testing** (Chrome, Firefox, Edge, etc.)  
- ✅ **Headless execution** for faster CI/CD runs  
- ✅ **Parallel execution** to reduce test cycle time  
- ✅ **ExtentReports integration** for rich HTML reporting with screenshots and detailed logs  
- ✅ **Log4j logging** for configurable, structured logging across test lifecycle  
- ✅ **Data-driven testing** with support for **Excel, CSV, and JSON** files  
- ✅ **Scalable design** for enterprise-grade automation needs  

---

## 📂 Project Structure
automation_assignment/
│
├── .settings/                  # IDE-specific configuration files
│
├── config/                     # Environment & configuration files
│   └── config.json             # Browser, environment, credentials
│
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       ├── constants/      # Global constants & enums
│       │       ├── dataproviders/  # TestNG DataProviders
│       │       ├── listeners/      # TestNG listeners (Extent, Retry)
│       │       ├── pages/          # Page Object Model (POM) classes
│       │       ├── pojo/           # POJO classes for test data mapping
│       │       ├── tests/          # Test classes
│       │       └── utility/        # Utilities (Excel, JSON, Logger, Screenshots)
│       │
│       └── resources/
│           └── log4j2.xml          # Log4j2 configuration
│
├── testData/                   # Data-driven test files
│   ├── loginData.csv
│   ├── loginData.xlsx
│   └── loginData.json
│
├── .classpath                  # Eclipse classpath configuration
├── .project                    # Eclipse project configuration
├── .gitignore                  # Git ignore rules
├── pom.xml                     # Maven dependencies & build config
├── testng.xml                  # TestNG suite configuration

## 📂 Project Structure (Styled)

```mermaid
graph LR;
    ROOT((Project Root))
    ROOT --> SETTINGS[.settings/]
    ROOT --> CONFIG[config/]
    CONFIG --> CONFIGJSON[config.json]
    ROOT --> SRC[src/]
    SRC --> TEST[test/]
    TEST --> JAVA[java/]
    JAVA --> CONSTANTS[constants/]
    JAVA --> DATAPROVIDERS[dataproviders/]
    JAVA --> LISTENERS[listeners/]
    JAVA --> PAGES[pages/]
    JAVA --> POJO[pojo/]
    JAVA --> TESTS[tests/]
    JAVA --> UTILITY[utility/]
    TEST --> RESOURCES[resources/]
    RESOURCES --> LOG4J[log4j2.xml]
    ROOT --> TESTDATA[testData/]
    TESTDATA --> CSV[loginData.csv]
    TESTDATA --> XLSX[loginData.xlsx]
    TESTDATA --> JSON[loginData.json]
    ROOT --> CLASSPATH[.classpath]
    ROOT --> PROJECT[.project]
    ROOT --> GITIGNORE[.gitignore]
    ROOT --> POM[pom.xml]
    ROOT --> TESTNG[testng.xml]


## ⚡ Getting Started

### 🔧 Prerequisites
- Install **Java 11+**
- Install **Maven 3.6+**
- IDE (IntelliJ IDEA / Eclipse recommended)

### ▶️ Running Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/automation_assignment.git

2. Navigate to the project directory:
cd automation_assignment
Run tests with Maven: mvn clean test
3. Execute on LambdaTest (update credentials ).

**Cloud Execution (LambdaTest)**
Configure your LambdaTest credentials in the project config.

Supports running tests across multiple browsers and OS combinations.

Enables parallel execution for faster feedback cycles.

📊 **Reporting & Logging**
**ExtentReports** → Interactive HTML reports with screenshots, logs, and test status.

**TestNG Reports** → Default execution summary.

**Log4j** → Centralized, configurable logging for debugging and monitoring.

📑 **Data-Driven Testing**
Supports Excel, CSV, and JSON as data sources.

Enables parameterized test execution with dynamic datasets.

Simplifies regression testing by separating test logic from test data.

🤝 **Contributing**
Contributions are welcome!

Fork the repo

Create a feature branch

Submit a pull request
