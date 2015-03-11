package com.terians.dto.transformer;

import com.terians.dto.IssuesDTO;
import com.terians.neo4j.repository.IssueRepository;

/**
 * Created by stromero on 3/10/2015.
 */
public class IssuesDTOUtil {

    public static IssuesDTO findAllIssues(IssueRepository issueRepository, String scanId, String category,
                                          String orderedBy, int limit) {

        IssuesDTO issuesDTO = null;

        if ((category == null) && (orderedBy == null) && (limit == 0)) {

            issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllIssues());

        } else if ((category == null)) {

            String orderedByArray[] = orderedBy.split(",");
            String orderedByValue = orderedByArray[0];
            String descOrAsc = orderedByArray[1];

            switch (orderedByValue) {
                case "issuecount": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                .findIssuesByScanOrderedByIssueCountDesc(scanId, limit));
                    }
                    break;
                }
                case "categorycount": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                .findIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
                    }
                    break;
                }
                case "filenamecount": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                .findIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
                    }
                    break;
                }
                case "packagecount": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.
                                findIssuesByScanOrderedByPackageCountDesc(scanId, limit));
                    }
                    break;
                }
                case "clazzcount": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                .findIssuesByScanOrderedByClazzCountDesc(scanId, limit));
                    }
                    break;
                }
                case "issuetype": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                .findIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
                    }
                    break;
                }
                case "techdebt": {
                    if (descOrAsc.equals("desc")) {
                        issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                .findIssuesByScanOrderedByTechDebtDesc(scanId, limit));
                    }
                    break;
                }
            }

        } else if ((orderedBy == null) && (limit == 0)) {

            switch (category) {
                case "critical": {
                    issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                            .findAllCriticalIssuesByScan(scanId));
                    break;
                }
                case "high": {
                    issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                            .findAllHighIssuesByScan(scanId));
                    break;
                }
                case "medium": {
                    issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                            .findAllMediumIssuesByScan(scanId));
                    break;
                }
                case "low": {
                    issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                            .findAllLowIssuesByScan(scanId));
                    break;
                }
                case "bestpractices": {
                    issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                            .findAllBestPracticesIssuesByScan(scanId));
                    break;
                }
            }

        } else if ((orderedBy != null) && (limit != 0)) {

            switch (category) {
                case "critical": {

                    String orderedByArray[] = orderedBy.split(",");
                    String orderedByValue = orderedByArray[0];
                    String descOrAsc = orderedByArray[1];

                    switch (orderedByValue) {
                        case "issuecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByIssueCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "categorycount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "filenamecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "packagecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByPackageCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "clazzcount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByClazzCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "issuetype": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
                            }
                            break;
                        }
                        case "techdebt": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findCriticalIssuesByScanOrderedByTechDebtDesc(scanId, limit));
                            }
                            break;
                        }
                    }
                    break;
                }
                case "high": {

                    String orderedByArray[] = orderedBy.split(",");
                    String orderedByValue = orderedByArray[0];
                    String descOrAsc = orderedByArray[1];

                    switch (orderedByValue) {
                        case "issuecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByIssueCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "categorycount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "filenamecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "packagecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByPackageCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "clazzcount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByClazzCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "issuetype": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
                            }
                            break;
                        }
                        case "techdebt": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findHighIssuesByScanOrderedByTechDebtDesc(scanId, limit));
                            }
                            break;
                        }
                    }
                    break;
                }
                case "medium": {

                    String orderedByArray[] = orderedBy.split(",");
                    String orderedByValue = orderedByArray[0];
                    String descOrAsc = orderedByArray[1];

                    switch (orderedByValue) {
                        case "issuecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByIssueCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "categorycount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "filenamecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "packagecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByPackageCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "clazzcount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByClazzCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "issuetype": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
                            }
                            break;
                        }
                        case "techdebt": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findMediumIssuesByScanOrderedByTechDebtDesc(scanId, limit));
                            }
                            break;
                        }
                    }
                    break;
                }
                case "low": {

                    String orderedByArray[] = orderedBy.split(",");
                    String orderedByValue = orderedByArray[0];
                    String descOrAsc = orderedByArray[1];

                    switch (orderedByValue) {
                        case "issuecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByIssueCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "categorycount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "filenamecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "packagecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByPackageCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "clazzcount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByClazzCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "issuetype": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
                            }
                            break;
                        }
                        case "techdebt": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findLowIssuesByScanOrderedByTechDebtDesc(scanId, limit));
                            }
                            break;
                        }
                    }
                    break;
                }
                case "bestpractices": {

                    String orderedByArray[] = orderedBy.split(",");
                    String orderedByValue = orderedByArray[0];
                    String descOrAsc = orderedByArray[1];

                    switch (orderedByValue) {
                        case "issuecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByIssueCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "categorycount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "filenamecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "packagecount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByPackageCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "clazzcount": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByClazzCountDesc(scanId, limit));
                            }
                            break;
                        }
                        case "issuetype": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
                            }
                            break;
                        }
                        case "techdebt": {
                            if (descOrAsc.equals("desc")) {
                                issuesDTO = DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository
                                        .findBestPracticesIssuesByScanOrderedByTechDebtDesc(scanId, limit));
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return issuesDTO;
    }
}
