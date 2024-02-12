package com.isteer.dcm.service;

import com.isteer.dcm.entity.LogTable;

import com.isteer.dcm.repository.LogRepository;
import com.isteer.dcm.utility.DcmUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogServiceImpl {

    @Autowired
    private LogRepository logEntryRepository;


    public void logData(String processName, String errorMessage, String stackTrace, String processId, String request, String response) {
        // Mandatory Parameters
        if (processName == null || processName.isEmpty()) {
            processName = "Unknown Process"; // Default process name
        }

        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = "No error message provided"; // Default error message
        }

        // Optional Parameters
        String truncatedStackTrace = null;
        if (stackTrace != null && !stackTrace.isEmpty()) {
            truncatedStackTrace = DcmUtility.getStacktraceSubString(stackTrace);
        }

        LogTable logEntry = new LogTable();
        logEntry.setProcessName(processName);
        logEntry.setErrorMessage(errorMessage);
        logEntry.setStartDateTime(LocalDateTime.now());

        if (processId != null && !processId.isEmpty()) {
            logEntry.setProcessId(processId);
        }

        if (truncatedStackTrace != null) {
            logEntry.setStackTrace(truncatedStackTrace);
        }

        logEntry.setStatus("Error");

        if (request != null && !request.isEmpty()) {
            logEntry.setRequest(request);
        }

        if (response != null && !response.isEmpty()) {
            logEntry.setResponse(response);
        }

//        logEntryRepository.insertLog(logEntry);

        try {

            logEntryRepository.save(logEntry);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}