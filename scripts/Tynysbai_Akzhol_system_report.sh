#!/bin/bash
# System report script for Tynysbai Akzhol (IT2-2306, ID 38313)

LOG_FILE="$(dirname "$0")/../logs/Tynysbai_Akzhol_system_report.log"

{
echo "=============================="
echo "System Report"
echo "=============================="
echo "Student: Akzhol Tynysbai"
echo "Group: IT2-2306"
echo "Student ID: 38313"
echo "Date and time: $(date)"
echo "Username: $(whoami)"
echo "Operating system: $(grep PRETTY_NAME /etc/os-release | cut -d'"' -f2)"
echo "Kernel version: $(uname -r)"
echo "------------------------------"
echo "CPU information:"
lscpu | grep -E "Model name|^CPU\(s\)"
echo "------------------------------"
echo "Memory information:"
free -h
echo "------------------------------"
echo "Disk usage:"
df -h /
echo "------------------------------"
echo "Available disk space: $(df -h / | awk 'NR==2 {print $4}')"
echo "=============================="
} | tee -a "$LOG_FILE"
