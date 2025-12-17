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
    ROOT((Project Root)):::root

    ROOT --> SETTINGS[.settings/]:::folder
    ROOT --> CONFIG[config/]:::folder
    CONFIG --> CONFIGJSON[config.json]:::file

    ROOT --> SRC[src/]:::highlight
    SRC --> TEST[test/]:::folder
    TEST --> JAVA[java/]:::folder
    JAVA --> CONSTANTS[constants/]:::folder
    JAVA --> DATAPROVIDERS[dataproviders/]:::folder
    JAVA --> LISTENERS[listeners/]:::folder
    JAVA --> PAGES[pages/]:::folder
    JAVA --> POJO[pojo/]:::folder
    JAVA --> TESTS[tests/]:::folder
    JAVA --> UTILITY[utility/]:::folder
    TEST --> RESOURCES[resources/]:::folder
    RESOURCES --> LOG4J[log4j2.xml]:::file

    ROOT --> TESTDATA[testData/]:::highlight
    TESTDATA --> CSV[loginData.csv]:::file
    TESTDATA --> XLSX[loginData.xlsx]:::file
    TESTDATA --> JSON[loginData.json]:::file

    ROOT --> CLASSPATH[.classpath]:::file
    ROOT --> PROJECT[.project]:::file
    ROOT --> GITIGNORE[.gitignore]:::file
    ROOT --> POM[pom.xml]:::important
    ROOT --> TESTNG[testng.xml]:::file

    %% Styles
    classDef root fill=#f9f,stroke=#333,stroke-width=2px;
    classDef folder fill=#bbf,stroke=#333,stroke-width=1px;
    classDef file fill=#fff,stroke=#999,stroke-width=1px;
    classDef highlight fill=#cfc,stroke=#333,stroke-width=2px;
    classDef important fill=#fc9,stroke=#333,stroke-width=2px;

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
