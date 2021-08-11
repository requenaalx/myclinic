package org.myclinic.model.service.exception

import org.myclinic.model.service.Status

class ActionNotAllowed(status: Status) :
    Exception("Action not allowed for a $status service")